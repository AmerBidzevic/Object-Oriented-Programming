package Lab13;
import java.util.*;

interface OldDevice {
    void operateOldFunction();
}

interface NewDevice {
    void operateNewFunction();
}

class OldDeviceImpl implements OldDevice {
    public void operateOldFunction() {
        System.out.println("Operating old device function.");
    }
}

class NewDeviceImpl implements NewDevice {
    public void operateNewFunction() {
        System.out.println("Operating new device function.");
    }
}

class DeviceAdapter implements NewDevice {
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    public void operateNewFunction() {
        oldDevice.operateOldFunction();
    }
}
class Main4{
    public static void main(String[] args) {
        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice adapter = new DeviceAdapter(oldDevice);
        adapter.operateNewFunction();
    }
}