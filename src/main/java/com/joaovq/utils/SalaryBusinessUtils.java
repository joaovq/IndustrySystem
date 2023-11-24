package com.joaovq.utils;

import com.joaovq.domain.Employer;
import com.joaovq.utils.contants.SalaryConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SalaryBusinessUtils {
    public static Double getQuantityMinSalaryAtSalaryValue(BigDecimal salaryValue) {
        return salaryValue.divide(SalaryConstant.minSalary, 2,RoundingMode.DOWN).doubleValue();
    }

    public static BigDecimal getTotalSalaryEmployers(List<Employer> employers) {
        BigDecimal totalSalaryIndustry = BigDecimal.ZERO;
        for (Employer employer : employers) {
            totalSalaryIndustry = totalSalaryIndustry.add(employer.getSalary());
        }
        return totalSalaryIndustry;
    }
}
