package ua.dp.skillsup.tdd;

import org.springframework.beans.factory.InitializingBean;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FeeService implements InitializingBean{

    private HolidayService holidayService;
    private WorkingService workingService;

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

    public FeeService(HolidayService holidayService) {

        this.holidayService = holidayService;
    }
    public FeeService(WorkingService workingService) {
        fee = 0.01;
        this.workingService = workingService;
    }

    public double getFee(double paymentAmount) {
        return fee;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FeeService Initialised with fee " + fee);
    }
}
