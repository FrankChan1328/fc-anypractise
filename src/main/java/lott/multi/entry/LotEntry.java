package lott.multi.entry;

public class LotEntry {
    /**
     * 基本环境数据
     */
    private LotContext context;
    
    private LotBasicCal cal;
    
    public LotEntry(LotContext context, LotBasicCal cal) {
        this.context = context;
        this.cal = cal;
    }

    public LotContext getContext() {
        return context;
    }

    public void setContext(LotContext context) {
        this.context = context;
    }

    public LotBasicCal getCal() {
        return cal;
    }

    public void setCal(LotBasicCal cal) {
        this.cal = cal;
    }
}
