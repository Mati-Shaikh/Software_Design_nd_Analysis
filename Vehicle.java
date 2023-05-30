package application;

public class Vehicle {
	public String model_type;
	public String vehicle_Nm;
	public String getModel_type() {
		return model_type;
	}
	public void setModel_type(String model_type) {
		this.model_type = model_type;
	}
	public String getVehicle_Nm() {
		return vehicle_Nm;
	}
	public void setVehicle_Nm(String vehicle_Nm) {
		this.vehicle_Nm = vehicle_Nm;
	}
	@Override
	public String toString() {
		return "Vehicle [model_type=" + model_type + ", vehicle_Nm=" + vehicle_Nm + "]";
	}
	

}
