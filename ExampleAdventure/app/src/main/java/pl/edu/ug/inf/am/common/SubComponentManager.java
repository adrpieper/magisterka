package pl.edu.ug.inf.am.common;

public abstract class SubComponentManager {

    private SubComponentManager subComponentManager;
    private Class componentInterface;
    private final ComponentsManager componentsManager;

    protected SubComponentManager(ComponentsManager componentsManager) {
        this.componentsManager = componentsManager;
    }

    protected <C> void setSubcomponent(Class<C> componentInterface, C component){
        removeSubcomponent();
        if (component instanceof HasSubComponents) {
            subComponentManager = ((HasSubComponents) component).subComponentsManager();
        }
        this.componentInterface = componentInterface;
        componentsManager.add(componentInterface, component);
    }

    protected void removeSubcomponent(){
        if (componentInterface != null) {
            if (subComponentManager != null) {
                subComponentManager.removeSubcomponent();
            }
            componentsManager.remove(componentInterface);
        }
    }

    public Class getComponentInterface() {
        return componentInterface;
    }
}
