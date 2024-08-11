package parkingLot.models;

public class Gate extends BaseModel{
    private int GateNumber;
    //To know about the operator in Gate
    private Operator operator;
    private GateType gateType;
    private GateStatus gateStatus;

    public int getGateNumber() {
        return GateNumber;
    }

    public void setGateNumber(int gateNumber) {
        GateNumber = gateNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
