public class RideInfo {
    private String driverName;
    private float driverRate;

    public RideInfo() {
    }

    public RideInfo(String driverName, float driverRate) {
        this.driverName = driverName;
        setDriverRate(driverRate);
    }

    public String getDriverName() {
        return driverName;
    }

    public float getDriverRate() {
        return driverRate;
    }

    public void setDriverRate(float driverRate) {
        if(driverRate >= 0f && driverRate <= 5){
            this.driverRate = driverRate;
        }
    }
}
