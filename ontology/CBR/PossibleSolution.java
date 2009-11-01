/**
 * @see "Categor&iacute;a Sukia Reasoner en SUKIA SmallTalk"
 */
package ontology.CBR;

import jade.content.Concept;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsPrimitive;
import jade.content.abs.AbsTerm;
import jade.content.onto.Introspectable;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;

import ontology.common.Description;
import ontology.common.Descriptor;
import ontology.taxonomy.Taxon;


/**
 * @author Armando
 *
 */
public class PossibleSolution implements jade.content.Concept, Introspectable {
	private Description confirmedDescription;
	private Description unconfirmedDescription;
	private Description contradictions;
	private Description doubtfulDescription;
	private Description solutionDescription;
	private Hypothesis hypothesis;
	private Concept solution;
	private boolean evaluated;
	private String points;

	/**
	 * @see "M&eacute;todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public PossibleSolution() {
		this._internalInstanceName = "";
		setSolutionDescription(new Description());
		setConfirmedDescription(new Description());
		setUnconfirmedDescription(new Description());
		setDoubtfulDescription(new Description());
		setContradictions(new Description());
		setHypothesis(null);
		setSolution(null);
		setEvaluated(false);
		setPoints("0");
	}

  	private String _internalInstanceName = null;

  	public PossibleSolution(String instance_name) {
	  this._internalInstanceName = instance_name;
  	}

  	public String toString() {
	  return _internalInstanceName;
  	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param confirmedDescription
	 */
	public void setConfirmedDescription(Description confirmedDescription) {
		this.confirmedDescription = confirmedDescription;
	}
	
	/**
	 * @see "M&eacute;todo confirmedDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return
	 */
	public boolean addToConfirmedDescription(Descriptor aDescriptor) {
		return this.getConfirmedDescription().addToConcreteDescription(aDescriptor);
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M&eacute;todo confirmedDescription del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getConfirmedDescription() {
		return confirmedDescription;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * M&eacute;todo de instancia agregado
	 * @param contradictions
	 */
	public void setContradictions(Description contradictions) {
		this.contradictions = contradictions;
	}

	/**
	 * @see "M&eacute;todo contradictions: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return
	 */
	public boolean addToContradictions(Descriptor aDescriptor) {
		return this.getContradictions().addToAbstractDescription(aDescriptor);
	}
	
	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo contradictions del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getContradictions() {
		return contradictions;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param doubtfulDescription
	 */
	public void setDoubtfulDescription(Description doubtfulDescription) {
		this.doubtfulDescription = doubtfulDescription;
	}
	
	/**
	 * @see "M�todo doubtfulDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return
	 */
	public boolean addToDoubtfulDescription(Descriptor aDescriptor) {
		return this.getDoubtfulDescription().addToConcreteDescription(aDescriptor);
	}
	
	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo doubtfulDescription del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getDoubtfulDescription() {
		return doubtfulDescription;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @see "M�todo evaluated: del protocolo adding en SUKIA SmallTalk"
	 * @param evaluated
	 */
	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo evaluated del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public boolean isEvaluated() {
		return evaluated;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @see "M�todo hypothesis: del protocolo adding en SUKIA SmallTalk"
	 * @param hypothesis
	 */
	public void setHypothesis(Hypothesis hypothesis) {
		this.hypothesis = hypothesis;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo hypothesis del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Hypothesis getHypothesis() {
		return hypothesis;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param points
	 */
	public void setPoints(String points) {
		this.points = points;
	}
	
	/**
	 * @see "M�todo incrementPointsBy: del protocolo adding en SUKIA SmallTalk"
	 * @param increment
	 */
	public void incrementPointsBy(double increment) {
		this.points = this.points + increment;
	}
	
	/**
	 * @see "M�todo incrementPointsBy: del protocolo adding en SUKIA SmallTalk"
	 */
	public void incrementPoints() {
		this.points = this.points + 1;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo points del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public String getPoints() {
		return points;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @see "M�todo solution: del protocolo adding en SUKIA SmallTalk"
	 * @param solution
	 */
	public void setSolution(Concept solution) {
		// Make sure class of the PossibleSolution is OK
		if (!(solution instanceof Case || solution instanceof Taxon))
			return;

		this.solution = solution;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo solution del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Concept getSolution() {
		return solution;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param solutionDescription
	 */
	public void setSolutionDescription(Description solutionDescription) {
		this.solutionDescription = solutionDescription;
	}
	
	/**
	 * @see "M�todo solutionDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return
	 */
	public boolean addToSolutionDescription(Descriptor aDescriptor) {
		return this.getSolutionDescription().addToConcreteDescription(aDescriptor);
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo solutionDescription del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getSolutionDescription() {
		return solutionDescription;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param unconfirmedDescription
	 */
	public void setUnconfirmedDescription(Description unconfirmedDescription) {
		this.unconfirmedDescription = unconfirmedDescription;
	}

	/**
	 * @see "M�todo unconfirmedDescription: del protocolo adding en SUKIA SmallTalk"
	 * @param aDescriptor
	 * @return
	 */
	public boolean addToUnconfirmedDescription(Descriptor aDescriptor) {
		return this.getUnconfirmedDescription().addToConcreteDescription(aDescriptor);
	}
		
	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M�todo unconfirmedDescription del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getUnconfirmedDescription() {
		return unconfirmedDescription;
	}

	/**
	 * @see "M�todo appendToConfirmedDescription: del protocolo inheritance en SUKIA SmallTalk"
	 * @param aDescription
	 */
	public void addAllToConfirmedDescription(Description aDescription) {
		this.getConfirmedDescription().addAllToConcreteDescription(aDescription);
	}
	
	/**
	 * @see "M�todo appendToDoubtfulDescription: del protocolo inheritance en SUKIA SmallTalk"
	 * @param aDescription
	 */
	public void addAllToDoubtfulDescription(Description aDescription) {
		this.getDoubtfulDescription().addAllToConcreteDescription(aDescription);
	}

	/**
	 * @see "M�todo appendToSolutionDescription: del protocolo inheritance en SUKIA SmallTalk"
	 * @param aDescription
	 */
	public void addAllToSolutionDescription(Description aDescription) {
		this.getSolutionDescription().addAllToConcreteDescription(aDescription);
	}

	/**
	 * @see "M�todo appendToUnconfirmedDescription: del protocolo inheritance en SUKIA SmallTalk"
	 * @param aDescription
	 */
	public void addAllToUnconfirmedDescription(Description aDescription) {
		this.getUnconfirmedDescription().addAllToConcreteDescription(aDescription);
	}
	
	/**
	 * @see "M�todo appendToContradictions: del protocolo inheritance en SUKIA SmallTalk"
	 * @param aDescription
	 */
	public void addAllToContradictions(Description aDescription) {
		this.getContradictions().addAllToConcreteDescription(aDescription);
	}
	
	public String getLevel() {
		if (this.getSolution() == null) return null;
		
		if (this.getSolution() instanceof Case)
			return (((Case)this.getSolution()).getSolution().getTaxonLevel());

		if (this.getSolution() instanceof Taxon)
			return (((Taxon)this.getSolution()).getLevel());
		
		return null;
	}
	
	/**
	 * Devuelve el estado de la soluci�n que representa PossibleSolution
	 * @return true si la soluci�n es un Taxon o el caso es positivo o false si el caso es negativo
	 */
	public boolean getStatus() {
		// Taxon instances always have a positive status
		if (this.getSolution() instanceof Taxon)
			return true;

		// Return the status of the associated Case or SAVCase
		return (((Case)this.getSolution()).getState());
	}
	
	/*
	 * 
	 */
	public String getName() {
		if (this.getSolution() == null) return null;
		
		if (this.getSolution() instanceof Case)
			return (((Case)this.getSolution()).getSolution().getTaxonName());

		if (this.getSolution() instanceof Taxon)
			return (((Taxon)this.getSolution()).getName());
		
		return null;
	}

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_SOLUTIONDESCRIPTION, (AbsTerm) onto.fromObject(getSolutionDescription()));
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_CONFIRMEDDESCRIPTION, (AbsTerm) onto.fromObject(getConfirmedDescription()));
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_DOUBTFULDESCRIPTION, (AbsTerm) onto.fromObject(getDoubtfulDescription()));
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_UNCONFIRMEDDESCRIPTION, (AbsTerm) onto.fromObject(getUnconfirmedDescription()));
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_POINTS, (String)points);
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_CONTRADICTIONS, (AbsTerm) onto.fromObject(getContradictions()));
      abs.set(CBRTerminologyOntology.POSSIBLESOLUTION_SOLUTION, (AbsTerm) onto.fromObject(getSolution()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising PossibleSolution");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      solutionDescription = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_SOLUTIONDESCRIPTION));
      confirmedDescription = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_CONFIRMEDDESCRIPTION));
      doubtfulDescription = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_DOUBTFULDESCRIPTION));
      unconfirmedDescription = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_UNCONFIRMEDDESCRIPTION));
//      points = abs.getLong(CBRTerminologyOntology.POSSIBLESOLUTION_POINTS);
//      points = ((AbsPrimitive)(onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_POINTS));
      points = (String)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_POINTS));
      contradictions = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_CONTRADICTIONS));
      solution = (Concept)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.POSSIBLESOLUTION_SOLUTION));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising PossibleSolution");
     }
   }

}
