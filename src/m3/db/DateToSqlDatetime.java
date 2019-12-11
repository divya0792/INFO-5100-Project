package m3.db;

import java.util.Date;

import m3.model.Incentive;

public class DateToSqlDatetime {
    public static Date JavaStartDateToSqlDate(Incentive I) {
        java.util.Date utilDate1 = new java.util.Date(I.getStartDate().getTime());
        java.sql.Date sqlStartDate = new java.sql.Date(utilDate1.getTime());
        return sqlStartDate;
    }
    public static Date JavaEndDateToSqlDate(Incentive I) {
        java.util.Date utilDate2 = new java.util.Date(I.getEndDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(utilDate2.getTime());
        return sqlEndDate;
    }
}
