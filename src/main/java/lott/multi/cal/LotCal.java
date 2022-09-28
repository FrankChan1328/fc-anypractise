package lott.multi.cal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lot2.pre.BaseUtil;
import lot2.pre.PredictUtil;
import lott.entity.ColType;
import lott.entity.Lot;
import lott.entity.NumProbability;
import lott.multi.entry.LotEntry;
import lott.util.PossibilityUtil;

public class LotCal {
    /**
     * 当前是第几期(方便预测下一期)
     */
    private Integer term;
    
    private LotEntry entry;
    
    public LotCal(int term, LotEntry entry) {
        this.term = term;
        this.entry = entry;
    }
    
    public List<Lot> getTotalLots() {
        return entry.getContext().getLots();
    }

    public Lot getCurrent() {
        return getTotalLots().stream().filter(it -> it.getTerm() == term).findFirst().get();
    }

    public Lot getNext() {
        int nextTerm = BaseUtil.getNextTerm(getTotalLots(), 1, term);
        return getTotalLots().stream().filter(it -> it.getTerm() == nextTerm).findFirst().get();
    }

    public Lot getBefore() {
        int beforeTerm = BaseUtil.getBeforeTerm(getTotalLots(), 1, term);
        return getTotalLots().stream().filter(it -> it.getTerm() == beforeTerm).findFirst().get();
    }

    /**
     * 获取小于当前期数的lot
     */
    public List<Lot> getLots() {
        List<Lot> lots = entry.getContext().getLots().stream().filter(it -> {
            return term <= 0 || (term > 0 && it.getTerm() <= term);
        }).collect(Collectors.toList());
        return lots;
    }
    
    /**
     * 获取小于当前期数的lot
     */
    public List<Lot> getBeforeLots() {
        int beforeTerm = BaseUtil.getBeforeTerm(getTotalLots(), 1, term);
        List<Lot> lots = entry.getContext().getLots().stream().filter(it -> {
            return beforeTerm <= 0 || (beforeTerm > 0 && it.getTerm() <= beforeTerm);
        }).collect(Collectors.toList());
        return lots;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public LotEntry getEntry() {
        return entry;
    }

    public void setEntry(LotEntry entry) {
        this.entry = entry;
    }
}
