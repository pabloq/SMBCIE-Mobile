package ontology.taxonomy;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Introspectable;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.util.leap.ArrayList;
import jade.util.leap.Iterator;
import jade.util.leap.List;

import ontology.common.CharacterDescriptor;
import ontology.common.Description;
import ontology.common.Descriptor;
import ontology.common.HeuristicDescriptor;
import ontology.common.RVCharacterDescriptor;
import ontology.common.RVHeuristicDescriptor;

/**
 * @author Armando
 *
 */
public class WeightedDescription implements jade.content.Concept, Introspectable {

  private String _internalInstanceName = null;

  public WeightedDescription() {
    this._internalInstanceName = "";
  }

  public WeightedDescription(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: weightedDescriptors
   */
   private List weightedDescriptors = new ArrayList();
   public void addWeightedDescriptors(WeightedDescriptor elem) { 
     weightedDescriptors.add(elem);
   }
   public boolean removeWeightedDescriptors(WeightedDescriptor elem) {
     boolean result = weightedDescriptors.remove(elem);
     return result;
   }
   public void clearAllWeightedDescriptors() {
     weightedDescriptors.clear();
   }
   public Iterator getAllWeightedDescriptors() {return weightedDescriptors.iterator(); }
   public List getWeightedDescriptors() {return weightedDescriptors; }
   public void setWeightedDescriptors(List l) {weightedDescriptors = l; }
	   
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public List getCharacterStructuresList() {
		List structuresList;
		
		structuresList = new ArrayList();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d instanceof CharacterDescriptor) {
				// Determine if the structure name in Deescriptor has already been included in structureList
				if (!(structuresList.contains(d.getStructure()))) {
					// The structure name was not found in structureList. Append it to structureList
					structuresList.add(d.getStructure());
				} else continue;
			}
		}
		
		return structuresList;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las heur&iacute;sticas
	 */
	public final List getHeuristicStructuresList() {
		List structuresList;
		
		structuresList = new ArrayList();

		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d instanceof HeuristicDescriptor) {
				// Determine if the structure name in Deescriptor has already been included in structureList
				if (!(structuresList.contains(d.getStructure()))) {
					// The structure name was not found in structureList. Append it to structureList
					structuresList.add(d.getStructure());
				} else continue;
			}
		}
		
		return structuresList;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las heur&iacute;sticas
	 */
	public final List getStructuresList() {
		List structuresList;
		
		structuresList = new ArrayList();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			// Determine if the structure name in Deescriptor has already been included in structureList
			if (!(structuresList.contains(d.getStructure()))) {
				// The structure name was not found in structureList. Append it to structureList
				structuresList.add(d.getStructure());
			} else continue;
		}
		
		return structuresList;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de descriptores relacionados a aStructureName
	 */
	public final Description getDescription(String aStructureName) {
		Description description;
		
		description = new Description();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			// Determine if the structure name in Deescriptor has already been included in structureList
			if (d.getStructure().equals(aStructureName)) {
				description.addDescriptors(d);
			} else continue;
		}
		
		return description;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de descriptores relacionados a aStructureName
	 */
	public final Description getDescription() {
		Description description;
		
		description = new Description();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			description.addDescriptors(d);
		}
		
		return description;
	}
	
	/**
	 * Verifica si existen contradicciones entre los descriptores (estructura, atributo, valor) del caso
	 * Se dice que existe contradiccion  si existe dos descripciones distintas para el mismo par
	 * (estructura, atributo)
	 * @see "M&eacute;todo thereAreContradictions: del protocolo testing en SUKIA SmallTalk"
	 * @return
	 */
	public boolean areThereContradictions(Descriptor aDescriptor) {
		
		// Para cada par (atributo, valor) de aCase.
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d.getStructure().equals(aDescriptor.getStructure()) &&
					d.getAttribute().equals(aDescriptor.getAttribute())	) {
					return true; // Hay contradiccion
			}
		}

		return false;  //No hubo contradiccion
	}
	
	/**
	 * Appends aDescriptor to the variable description
	 * @see "M&eacute;todo addToDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la adici&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la adici&oacute;n no se llev&oacute; a cabo
	 */
	public boolean addToConcreteDescription(Descriptor aDescriptor) {
		if (aDescriptor == null) return false;
		
		if (aDescriptor instanceof RVCharacterDescriptor
				|| aDescriptor instanceof RVHeuristicDescriptor)
			return false;
		
		if (this.getDescription().getDescriptors().contains(aDescriptor) ||
				this.areThereContradictions(aDescriptor))
			return false;
		
		this.getWeightedDescriptors().add(new WeightedDescriptor(aDescriptor, new Modifier("1","1", "1")));
		//Collections.sort(this); //OJO
		
		return true;
	}
	
	/**
	 * Appends aDescriptor to the variable description
	 * @see "M&eacute;todo addToDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la adici&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la adici&oacute;n no se llev&oacute; a cabo
	 */
	public boolean addToConcreteDescription(Descriptor aDescriptor, Modifier modifier) {
		if (aDescriptor == null) return false;
		
		if (aDescriptor instanceof RVCharacterDescriptor
				|| aDescriptor instanceof RVHeuristicDescriptor)
			return false;
		
		if (this.getDescription().getDescriptors().contains(aDescriptor) ||
				this.areThereContradictions(aDescriptor))
			return false;
		
		this.getWeightedDescriptors().add(new WeightedDescriptor(aDescriptor, modifier));
		//Collections.sort(this); //OJO
		
		return true;
	}
	
	/**
	 * @see "M�todo copyToJustificationFrom: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescription
	 * @return
	 */
	public boolean addAllToConcreteDescription(Description aDescription) {
		if (aDescription == null) return false;
		
		Iterator i = aDescription.getAllDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = (Descriptor) i.next(); 
            this.addToConcreteDescription(d);
            //Collections.sort(this); //OJO
        }
        
		return true;
	}
	
	/**
	 * @see "M�todo copyToJustificationFrom: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescription
	 * @return
	 */
	public boolean addAllToAbstractDescription(Description aDescription) {
		if (aDescription == null) return false;
		
		Iterator i = aDescription.getAllDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = (Descriptor) i.next();
            this.addToAbstractDescription(d);
            //Collections.sort(this); //OJO
        }
        
		return true;
	}
	
	/**
	 * Appends aDescriptor to the variable description
	 * @see "M&eacute;todo addToDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la adici&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la adici&oacute;n no se llev&oacute; a cabo
	 */
	public boolean addToAbstractDescription(Descriptor aDescriptor) {
		if (aDescriptor == null) return false;
		
		if (this.getWeightedDescriptors().contains(aDescriptor))
			return false;
		
		this.getWeightedDescriptors().add(new WeightedDescriptor(aDescriptor, new Modifier("1", "1", "1")));
		//Collections.sort(this);
		
		return true;
	}
	
	/**
	 * Appends aDescriptor to the variable description
	 * @see "M&eacute;todo addToDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la adici&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la adici&oacute;n no se llev&oacute; a cabo
	 */
	public boolean addToAbstractDescription(Descriptor aDescriptor, Modifier modifier) {
		if (aDescriptor == null) return false;
		
		if (this.getDescription().getDescriptors().contains(aDescriptor))
			return false;
		
		this.getWeightedDescriptors().add(new WeightedDescriptor(aDescriptor, modifier));
		//Collections.sort(this);
		
		return true;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de descriptores relacionados a aStructureName y aAttributeName
	 */
	public final Description getDescription(String aStructureName, String anAttributeName) {
		Description description;
		
		description = new Description();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			// Determine if the structure name in Deescriptor has already been included in structureList
			if (d.getStructure().equals(aStructureName) &&
					d.getAttribute().equals(anAttributeName)) {
				description.addDescriptors(d);
			} else continue;
		}
		
		return description;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public final List getAttributeList(String structureName) {
		List attributesList;
		
		attributesList = new ArrayList();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d.getStructure().equals(structureName)) {
				// Determine if the structure name in Deescriptor has already been included in structureList
				if (!(attributesList.contains(d.getAttribute()))) {
					// The structure name was not found in structureList. Append it to structureList
					attributesList.add(d.getAttribute());
				} else continue;
			}
		}
		
		return attributesList;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public final Description getCharacterList() {
		Description characterList;
		
		characterList = new Description();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d instanceof CharacterDescriptor) {
				// Determine if the structure name in Deescriptor has already been included in structureList
				if (!(characterList.getDescriptors().contains(d.getStructure()))) {
					// The structure name was not found in structureList. Append it to structureList
					characterList.addDescriptors(d);
				} else continue;
			}
		}
		
		return characterList;
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public final Description getHeuristicList() {
		Description heuristicList;
		
		heuristicList = new Description();
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d instanceof HeuristicDescriptor) {
				// Determine if the structure name in Deescriptor has already been included in structureList
				if (!(heuristicList.getDescriptors().contains(d.getStructure()))) {
					// The structure name was not found in structureList. Append it to structureList
					heuristicList.addDescriptors(d);
				} else continue;
			}
		}
		
		return heuristicList;
	}
	
	/**
	 * Removes aDescriptor from the variable description
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la remoci&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la remoci&oacute;n no se llev&oacute; a cabo
	 */
	public boolean removeFromDescription(Descriptor aDescriptor) {
		if (aDescriptor == null) return false;
		
		Iterator i = this.getAllWeightedDescriptors();
		
		while (i.hasNext()) {
			Descriptor d = ((WeightedDescriptor) i.next()).getDescriptor();
			if (d.equals(aDescriptor)) {
				this.getWeightedDescriptors().remove(i);
				return true;
			}
		}
		
		return false;
	}

 public void externalise(AbsObject absObj, Ontology onto) throws jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(TaxonomyOntology.WEIGHTEDDESCRIPTION_WEIGHTEDDESCRIPTORS, (AbsTerm) onto.fromObject(getWeightedDescriptors()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising WeightedDescription");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      weightedDescriptors = (List)onto.toObject(abs.getAbsObject(TaxonomyOntology.WEIGHTEDDESCRIPTION_WEIGHTEDDESCRIPTORS));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising WeightedDescription");
     }
   }
}
