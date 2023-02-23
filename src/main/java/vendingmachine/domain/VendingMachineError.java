package vendingmachine.domain;


public class VendingMachineError implements VendingMachineResult {
    String error;

    @Override
    public String toString() {
        return "VendingMachineError{" +
                "error='" + error + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendingMachineError that = (VendingMachineError) o;

        return error.equals(that.error);
    }

    @Override
    public int hashCode() {
        return error.hashCode();
    }

    public VendingMachineError(String error) {
        this.error = error;
    }
}


