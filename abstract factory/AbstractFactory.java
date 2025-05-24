interface UIElements{
    void render();
    void delete();
}
interface Button extends UIElements{
    void onClick();
}
interface Text extends UIElements{
    void onTextSelected();
}
interface UIElementsFactory{
    Button createButton();
    Text createText();
}

class WindowsButton implements Button{
    public void render(){
        System.out.println("Botão windows renderizado");
    }
    public void delete(){
        System.out.println("Botão windows deletado");
    }
    public void onClick(){
        System.out.println("Botão windows clicado");
    }
}
class WindowsText implements Text{
    public void render(){
        System.out.println("Texto windows renderizado");
    }
    public void delete(){
        System.out.println("Texto windows deletado");
    }
    public void onTextSelected(){
        System.out.println("Texto windows selecionado");
    }
}

class LinuxButton implements Button{
    public void render(){
        System.out.println("Botão linux renderizado");
    }
    public void delete(){
        System.out.println("Botão linux deletado");
    }
    public void onClick(){
        System.out.println("Botão linux clicado");
    }
}
class LinuxText implements Text{
    public void render(){
        System.out.println("Texto linux renderizado");
    }
    public void delete(){
        System.out.println("Texto linux deletado");
    }
    public void onTextSelected(){
        System.out.println("Texto linux selecionado");
    }
}   

class WindowsUIFactory implements UIElementsFactory{
    public Button createButton() {
        return new WindowsButton();
    }
    public Text createText(){
        return new WindowsText();
    }
}
class LinuxUIFactory implements UIElementsFactory{
    public Button createButton() {
        return new LinuxButton();
    }
    public Text createText(){
        return new LinuxText();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        String os = "windows";
        UIElementsFactory factory;

        factory = os == "windows" ? new WindowsUIFactory() : new LinuxUIFactory();

        Button button = factory.createButton();
        button.render();
    }
}
