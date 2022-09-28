package lott.entity;

public enum ColType {
    F01,
    F02,
    F03,
    F04,
    F05,
    E01,
    E02;
    
    public static int getRange(ColType type) {
        if (ColType.E01.equals(type) || ColType.E02.equals(type)) {
            return 12;
        }
        return 35;
    }
}
