package tp.myapp.minibank.impl.domain;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.mycontrib.generic.converter.GenericBeanConverter;
import org.mycontrib.generic.converter.common.DozerGenericBeanConverter;

@Local
@Stateless
public class GenericDozerBeanConverterAsEjb extends DozerGenericBeanConverter  implements GenericBeanConverter{

}
