package pl.adrian.pieper.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Created by Adi on 2016-09-18.
 */
public abstract class Generator {

    @Accessors
    Resource resource

    @Accessors
    String packageName;

    new(Resource resource, String packageName){
        this.resource = resource
        this.packageName = packageName
    }

    def String generateContent()
}