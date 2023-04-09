interface IPhone {
    void useLightning();
}

interface Android {
    void useTypeC();
}

class iPhone14 implements IPhone {
    public void useLightning() {
        System.out.println("Using Lightning Port.");
    }
}

class SamsungA32 implements Android {
    public void useTypeC() {
        System.out.println("Using Type C.");
    }
}

class TypeCToLightning implements Android {
    private IPhone iPhoneDevice;

    public TypeCToLightning(IPhone device) {
        this.iPhoneDevice = device;
    }

    public void useTypeC() {
        System.out.println("Adapting Lightning from Type C.");
        this.iPhoneDevice.useLightning();
    }
}

class Main {
    public static void main(String[] args) {
        IPhone iPhone14Max = new iPhone14();
        TypeCToLightning adapter = new TypeCToLightning(iPhone14Max);

        adapter.useTypeC();
    }
}
