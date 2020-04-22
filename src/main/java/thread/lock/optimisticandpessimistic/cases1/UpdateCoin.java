package thread.lock.optimisticandpessimistic.cases1;

/**
 * 游戏玩家需要更新玩家的游戏币数，
 * 更新后的金币数依赖于当前状态(如金币数、等级等)，因此更新前需要先查询玩家当前状态。
 *
 */
public class UpdateCoin {
	// *************** 方案1 **********************
	// 下面的实现方式，没有进行任何线程安全方面的保护。
	// 如果有其他线程在query和update之间更新了玩家的信息，会导致玩家金币数的不准确。
	//	@Transactional
	public void updateCoins(Integer playerId){
/*	    
 		//根据player_id查询玩家信息
		Player player = query("select coins, level from player where player_id = {0}", playerId);
		//根据玩家当前信息及其他信息，计算新的金币数
		Long newCoins = ……;
		//更新金币数
		update("update player set coins = {0} where player_id = {1}", newCoins, playerId);
*/
	}
	
	// *************** 方案2 **********************
	// 为了避免这个问题，悲观锁通过加锁解决这个问题，代码如下所示。
	// 在查询玩家信息时，使用select …… for update进行查询；
	// 该查询语句会为该玩家数据加上排它锁，直到事务提交或回滚时才会释放排它锁；
	// 在此期间，如果其他线程试图更新该玩家信息或者执行select for update，会被阻塞。
	//	@Transactional
	public void updateCoins2(Integer playerId){
/*
		//根据player_id查询玩家信息（加排它锁）
		Player player = queryForUpdate("select coins, level from player where player_id = {0} for update", playerId);
		//根据玩家当前信息及其他信息，计算新的金币数
		Long newCoins = ……;
		//更新金币数
		update("update player set coins = {0} where player_id = {1}", newCoins, playerId);
*/
	}
	
	
	// *************** 方案3 **********************
	// 版本号机制则是另一种思路，它为玩家信息增加一个字段：version。
	// 在初次查询玩家信息时，同时查询出version信息；
	// 在执行update操作时，校验version是否发生了变化，如果version变化，则不进行更新。
	// @Transactional
	public void updateCoins3(Integer playerId){
/*
		//根据player_id查询玩家信息，包含version信息
		Player player = query("select coins, level, version from player where player_id = {0}", playerId);
		//根据玩家当前信息及其他信息，计算新的金币数
		Long newCoins = ……;
		//更新金币数，条件中增加对version的校验
		update("update player set coins = {0}, version = version + 1 where player_id = {1} and version = {2}", newCoins, playerId, player.version);
*/
	}
}
