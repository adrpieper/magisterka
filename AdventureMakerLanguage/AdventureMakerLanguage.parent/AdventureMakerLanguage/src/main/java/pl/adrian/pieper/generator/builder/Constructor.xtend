package pl.adrian.pieper.generator.builder

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

class Constructor {
    @Accessors
    final String className
    @Accessors
    final List<Parameter> params
    @Accessors
    final String body

    new(String className, List<Parameter> params, String body){
        this.className = className
        this.params = params
        this.body = body
    }

    new(String className, List<Parameter> params){
        this(className, params, null)
    }
}