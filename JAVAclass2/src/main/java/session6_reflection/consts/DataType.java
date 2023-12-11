package session6_reflection.consts;


import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

public enum DataType {
    VARCHAR("varchar"),
    DOUBLE("double"),
    INT("int")
    ;
    public final String val;
    DataType(String val) {
        this.val = val;
    }

}
