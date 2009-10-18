/**
 * @see "Categor&iacute;a Main de SUKIA Smalltalk"
 */
package ontology.common;


/**
 * Descriptor es un elemento descriptivo de la descripción de un caso: el par attribute-value.
 * Generaliza conceptos en normas.
 * Todas las raíces de red (especializaciónes de normas) contienen un descriptor de la forma (nil, nil),
 * ya que ning&uacute;n par attribute-value particular generaliza todos los casos bajo ellos.
 * 
*/
public class SVHeuristicDescriptor extends QuantitativeHeuristicDescriptor {
	SingleValue value;
	
	public SVHeuristicDescriptor() {
		
	}
	
	private static final long serialVersionUID = -3087841394215437493L;

	public SVHeuristicDescriptor(String instance_name) {
		super(instance_name);
	}
	
	/**
	 * Class instance invariant: self MUST always have exactly two values. The first
	 * element corresponds to the descriptor's attribute, and the second one to the value.
	 * Extreme care should be taken when using this method, as it assumes an empty self."
	 * @see "M&eacute;todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public SVHeuristicDescriptor(String aStructure, String aAttribute, SingleValue aValue) {
		super(aStructure, aAttribute);
		this.setValue(aValue);
	}
	
	public void setValue(Object value) {
		this.value = (SingleValue)value;
	}

	public Object getValue() {
		return (SingleValue)value;
	}
}
