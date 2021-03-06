/**
 * @see "Categor�a Sukia Domain Theory de SUKIA Smalltalk"
 */
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
import jade.util.leap.Set;
import jade.util.leap.SortedSetImpl;

import ontology.common.Description;
import ontology.common.Descriptor;


/**
 * @author Armando
 *
 */
public class Taxon implements jade.content.Concept, Introspectable{
	private String level;
	private String name;
	private Taxon predecessor;
	private List successors;
	private WeightedDescription weightedDescription;

	/**
	 * @see "M�todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public Taxon(String level, String name) {
		setLevel(level);
		setName(name);
		predecessor = null;
		setSuccessors(new ArrayList());
		setWeightedDescription(new WeightedDescription());
	}

	private String _internalInstanceName = null;

  	public Taxon() {
	  this._internalInstanceName = "";
  	}

  	public Taxon(String instance_name) {
	  this._internalInstanceName = instance_name;
	  setSuccessors(new ArrayList());
  	}

  	public String toString() {
	  return _internalInstanceName;
  	}

	/**
	 * @see "M�todo level: del protocolo adding en SUKIA SmallTalk"
	 * @param level
	 */
	public void setLevel(String level) {
		boolean iscontained = false;

                for (int i = 0; i< TaxonomicRank.values.size();i++){

                    if (TaxonomicRank.values.get(i).equals(level)){
				iscontained = true;
				break;
			}

                }
		if (iscontained) this.level = level;
	}

	/***
	 * The name of any taxonomic level must be a sequnce of ByteSymbol characters, and it must
	 * be included in the class TaxonomicLevels (i.e., TaxonomicLevels includes: aLevel must be TRUE
	 * before the argument can be assigned to the instance variable 'level'.
	 * NOTE: This program assumes that the argument has been previously verified by the View-related objects.
	 * @see "M�todo level del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public String getLevel() {
		return level;
	}

	/***
	 * The name of  any taxon must be a single sequence of ByteSymbol characters. This program assumes
	 * that the argument 'aName' has been previously verified by the View-related objects. To avoid name
	 * confusion or duplications, without exception ALL NAMES MUST BE IN LOWERCASE LETTERS.
	 * Names belonging to the species level MUST have an underscore between the genus name and the
	 * epithet. The two main reasons for having species names in this format are:
	 * 1. Search speed: it's faster to compare against the species' instance variable 'name', than having to
	 * 	compare the epithet part against the species' 'name' and then asking its corresponding predecessor
	 * 	taxon (the genus) for it's name, before any comparison can be made.
	 * 2. In the unlikely event that a species Taxon ever became unlinked from the hierarchy, it would a lot
	 * 	easier to link it again to its parent genus if the name is complete (i..e, genus + epithet) that if the
	 * 	name consisted only of the epithet.
	 * Examples:
	 * 	For a family, the name might be: #fabaceae.
	 * 	For a genus: #lantana.
	 * 	For a species, the name MUST be composed of the corresponding genus name plus the epithet,
	 * 	separated by an undersore: #lantana_camara.
	 * @see "M�todo name: del protocolo adding en SUKIA SmallTalk"
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @see "M�todo name del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @see "M�todo predecessor: del protocolo adding-private en SUKIA SmallTalk"
	 * @param predecessor
	 */
	public void setPredecessor(Taxon predecessor) {
		if (predecessor == null) return; //Ojo revisar comportamiento
		
		if (this.predecessor != predecessor) {
			this.predecessor = predecessor;
			this.predecessor.addSuccessor(this);
		}
	}

	/**
	 * @see "M�todo predecessor del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Taxon getPredecessor() {
		return predecessor;
	}

	/**
	 * M�todo de instancia agregado
	 * @param sucessor
	 */
	public void setSuccessors(List sucessors) {
		this.successors = sucessors;
		sortTaxon(this.successors);
	}

	/**
	 * @see "M�todo successors del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public List getSuccessors() {
		return successors;
	}
	
	/**
	 * @see "M�todo sucessor: del protocolo adding-private en SUKIA SmallTalk"
	 * @param sucessor
	 */
	public boolean addSuccessor(Taxon successor) {
       if (TaxonomicRank.getIndex(successor.getLevel())
    		   - TaxonomicRank.getIndex(this.getLevel()) != 1)
    	   return false; //Verificar comportamiento
       
		if (!this.getSuccessors().contains(successor)) {
			this.successors.add(successor);
			sortTaxon(this.successors);
			successor.setPredecessor(this);
			return true;
		}
		
		return false;
	}
	
	public void clearAllSuccessors() {
		successors.clear();
	}
	
	public Iterator getAllSuccessors() {return successors.iterator(); }

	/***
	 * M�todo de instancia agregado
	 * @param sAVDescription
	 */
	public void setWeightedDescription(WeightedDescription aDescription) {
		this.weightedDescription = aDescription;
	}

	/**
	 * @see "M�todo SAVdescription del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public WeightedDescription getWeightedDescription() {
		return weightedDescription;
	}	
	
	/**
	 * @see "M�todo SAVdescription del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getDescription() {
		return this.getWeightedDescription().getDescription();
	}
   
	/**
	 * @see "M�todo isSuccessorOf: del protocolo inhetitence en SUKIA SmallTalk"
	 */
	public boolean isSuccessorOf(Taxon aTaxon) {
		Taxon  predecessorTaxon;
		
		if (TaxonomicRank.getIndex(getLevel())
				<= TaxonomicRank.getIndex(aTaxon.getLevel()))
			return false;
		
		predecessorTaxon = predecessor;
		while (!(predecessorTaxon.getLevel().equals(TaxonomicRank.ROOT))) {
			if (predecessorTaxon.getName().equals(aTaxon.getName()))
				return true;

			predecessorTaxon = predecessorTaxon.getPredecessor();
		}
		
		return false;
	}
	
	/**
	 * @see "M�todo unlinkFromTheHierarchy del protocolo linking en SUKIA SmallTalk"
	 */
	public void unlinkFromTheHierarchy() {
		Taxon p;
		
		p = predecessor;
		for (int i = 1; i <= p.getSuccessors().size(); i++) {
			if (p.getSuccessors().get(i-1).equals(this)) {
				 p.getSuccessors().remove(i-1);
				 predecessor = null; 
			}
		}
	}
	
	/**
	 * Appends aDescriptor to the variable description
	 * @see "M&eacute;todo addToDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la adici&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la adici&oacute;n no se llev&oacute; a cabo
	 */
	public boolean addToDescription(Descriptor aDescriptor) {
		return this.getWeightedDescription().addToAbstractDescription(aDescriptor);
	}
	
	public boolean addToDescription(Descriptor aDescriptor, Modifier aModifier) {
		return this.getWeightedDescription().addToAbstractDescription(aDescriptor, aModifier);		
	}
		
	/**
	 * Removes aDescriptor from the variable description
	 * @param aDescriptor
	 * @return Valor de verdad true indicando que la remoci&oacute;n se llev&oacute; a cabo
	 * @return Valor de verdad false indicando que la remoci&oacute;n no se llev&oacute; a cabo
	 */
	public boolean removeFromDescription(Descriptor aDescriptor) {
		return this.getWeightedDescription().removeFromDescription(aDescriptor);
	}
	
	/**
	 * @see "M�todo isLinkOKBetween:and: del protocolo de clase testing en SUKIA SmallTalk"
	 * @param aParentTaxon
	 * @param aSuccessorTaxon
	 * @return
	 */
	public boolean isOKDirectLink(Taxon aParentTaxon) {
		return (TaxonomicRank.getIndex(getLevel())
				- (TaxonomicRank.getIndex(aParentTaxon.getLevel())) == 1);
	}
	
	/**
	 * M�todo de instancia agregado
	 */
	public int compareTo(Taxon aTaxon) {
		return this.getName().compareTo(aTaxon.getName());
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de descriptores relacionados a aStructureName
	 */
	public final Description getDescription(String aStructureName) {
		return this.getDescription().getDescription(aStructureName);
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public final List getCharacterStructuresList() {
		return this.getDescription().getCharacterStructuresList();
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public final List getHeuristicStructuresList() {
		return this.getDescription().getHeuristicStructuresList();
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de cadenas representando el nombre de las estructuras
	 */
	public final List getAttributeList(String structureName) {
		return this.getDescription().getAttributeList(structureName);
	}
	
	/**
	 * M&eacute;todo de instancia agregado
	 * @return una lista de descriptores relacionados a aStructureName y aAttributeName
	 */
	public final Description getDescription(String aStructureName, String anAttributeName) {
		return this.getDescription().getDescription(aStructureName, anAttributeName);
	}
	
	private void sortTaxon(List taxonList) {
		Set taxonSet = new SortedSetImpl();
		
		Iterator i = taxonList.iterator();
		
		while (i.hasNext()) {
			taxonSet.add(i.next());
		}
		
		taxonList.clear();
		
		Iterator j = taxonSet.iterator();
		
		while (j.hasNext()) {
			taxonList.add(j.next());
		}
	}

public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(TaxonomyOntology.TAXON_WEIGHTEDDESCRIPTION, (AbsTerm) onto.fromObject(getWeightedDescription()));
      abs.set(TaxonomyOntology.TAXON_NAME, (AbsTerm) onto.fromObject(getName()));
      abs.set(TaxonomyOntology.TAXON_LEVEL, (AbsTerm) onto.fromObject(getLevel()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Taxon");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      weightedDescription = (WeightedDescription)onto.toObject(abs.getAbsObject(TaxonomyOntology.TAXON_WEIGHTEDDESCRIPTION));
      name = (String)onto.toObject(abs.getAbsObject(TaxonomyOntology.TAXON_NAME));
      level = (String)onto.toObject(abs.getAbsObject(TaxonomyOntology.TAXON_LEVEL));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Taxon");
     }
   }
}
