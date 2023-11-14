package session6_reflection.consts;


import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

public enum DataType implements TypeMirror {
    STRING("String"),
    INT("int"),
    INTEGER("Integer"),
    DATE("Date"),
    STUDENTS("Date")
    ;
    public final String val;
    DataType(String val) {
        this.val = val;
    }

    @Override
    public TypeKind getKind() {
        return TypeKind.valueOf(val);
    }

    @Override
    public List<? extends AnnotationMirror> getAnnotationMirrors() {
        return null;
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        return null;
    }

    @Override
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType) {
        return null;
    }
    @Override
    public <R, P> R accept(TypeVisitor<R, P> v, P p) {
        return null;
    }
}
