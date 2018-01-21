package ua.dp.skillsup.tdd;

import org.springframework.beans.factory.InitializingBean;

public class FeeService implements InitializingBean{

    private HolidayService holidayService;
    private WorkingService workingService;
    private WeekendService weekendService;

    private double fee;

    public void setFee(double fee) {

        this.fee = fee;
    }

    public void setHolidayService(HolidayService holidayService) {

        this.holidayService = holidayService;
    }

    public void setWorkingService(WorkingService workingService) {

        this.workingService = workingService;
    }

    public FeeService() {
    }


    public FeeService(WorkingService workingService) {
        fee = 0.01;
        this.workingService = workingService;
    }

    public FeeService(WeekendService weekendService) {
        fee = 0.015;
        this.weekendService = weekendService;
    }

    public FeeService(HolidayService holidayService, WorkingService workingService) {
        fee = 0.015;
        this.holidayService = holidayService;
        this.workingService = workingService;
    }
    public FeeService(HolidayService holidayService, WeekendService weekendService){
        fee =0.02;
        this.holidayService = holidayService;
        this.weekendService = weekendService;

    }

    public double getFee(double paymentAmount) {

        return fee;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FeeService Initialised with fee " + fee);
    }
}
