/**
 * @see "Categor�a Sukia Values de SUKIA Smalltalk"
 */
package ontology.common;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsPrimitive;
import jade.content.abs.AbsTerm;
import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;

/**
 * @author Armando
 *
 */
public class RangeValue extends Value {
	private String lowerBound;
	private String upperBound;

  	private String _internalInstanceName = null;
  
	public String get_internalInstanceName() {
		return _internalInstanceName;
	}

	public RangeValue(String instance_name) {
		this._internalInstanceName = instance_name;
	}

	/**
	 * 
	 */
	public RangeValue() {
		// this is set up for weighted values as default
		super();
		setMeasuringUnit(MeasuringUnit.getMeasuringUnit());
		this._internalInstanceName = "";
	}
	
	/**
	 * Constructor altenativo
	 */
	public RangeValue(String lowerBound, String upperBound) {
		this.setLowerBound(lowerBound);
		this.setUpperBound(upperBound);
		this.setMeasuringUnit(MeasuringUnit.getMeasuringUnit());
	}
	
	/**
	 * Constructor altenativo
	 */
	public RangeValue(String lowerBound, String upperBound, String measurinUnit) {
		this.setLowerBound(lowerBound);
		this.setUpperBound(upperBound);
		this.setMeasuringUnit(measurinUnit);
	}

	/**
	 * @see "M�todo copyFrom:referencing: del protocolo copying en SUKIA SmallTalk"
	 * @param aValue
	 * @param aTaxon
	 */
	public RangeValue(RangeValue aValue) {
		this.setLowerBound(aValue.getLowerBound());
		this.setUpperBound(aValue.getUpperBound());
		this.setMeasuringUnit(aValue.getMeasuringUnit());
	}

	/**
	 * @see "M�todo lowerBound del protocolo adding-range values en SUKIA SmallTalk"
	 * @return
	 */
	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}

	/**
	 * @see "M�todo lowerBound del protocolo accessing-range values en SUKIA SmallTalk"
	 * @return
	 */
	public String getLowerBound() {
		return lowerBound;
	}

	/**
	 * @see "M�todo upperBound del protocolo adding-range values en SUKIA SmallTalk"
	 * @return
	 */
	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}

	/**
	 * @see "M�todo upperBound del protocolo accessing-range values en SUKIA SmallTalk"
	 * @return
	 */
	public String getUpperBound() {
		return upperBound;
	}	
	
	/**
	 * M�todo agregado
	 * @param aValue
	 * @return
	 */
	public boolean equals(Object aValue) {
		return true;
	}
	
        /**
	 * 
	 */
	public String toString() {
		return  this.getLowerBound()+ "-" + this.getUpperBound() 
			+ " " + this.getMeasuringUnit();
	}
        public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
            try {
                AbsConcept abs = (AbsConcept) absObj;
                abs.set(CommonTerminologyOntology.VALUE_MEASURINGUNIT, (AbsTerm) onto.fromObject(getMeasuringUnit()));
                AbsPrimitive aPrimitive = new AbsPrimitive(BasicOntology.STRING);
                AbsPrimitive aPrimitive2 = new AbsPrimitive(BasicOntology.STRING);
                aPrimitive.set(getLowerBound());
                aPrimitive2.set(getUpperBound());
                abs.set(CommonTerminologyOntology.RANGEVALUE_LOWERBOUND, aPrimitive);
                abs.set(CommonTerminologyOntology.RANGEVALUE_UPPERBOUND, aPrimitive2);
            } catch (ClassCastException cce) {
                throw new OntologyException("Error externalising Value");
            }
        }

        public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
            try {
                AbsConcept abs = (AbsConcept) absObj;
                setMeasuringUnit((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.VALUE_MEASURINGUNIT)));
                setLowerBound((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.RANGEVALUE_LOWERBOUND)));
                setUpperBound((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.RANGEVALUE_UPPERBOUND)));
            } catch (ClassCastException cce) {
                throw new OntologyException("Error internalising Value");
            }
        }
}
