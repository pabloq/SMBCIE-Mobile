// file: CBRTerminologyOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package ontology.CBR;

import ontology.common.CommonTerminologyOntology;
import ontology.taxonomy.TaxonomyOntology;
import jade.content.onto.*;
import jade.content.schema.*;

/** file: CBRTerminologyOntology.java
 * @author ontology bean generator
 * @version 2009/10/6, 23:03:27
 */
public class CBRTerminologyOntology extends jade.content.onto.Ontology  {

  //NAME
  public static final String ONTOLOGY_NAME = "CBRTerminology";
  // The singleton instance of this ontology
  private static Ontology theInstance = new CBRTerminologyOntology();
  public static Ontology getInstance() {
     return theInstance;
  }

   // VOCABULARY
  	public static final String ARESIMILARTO_FAILURECONFLICTSET="failureConflictSet";
  	public static final String ARESIMILARTO_PROBLEM="problem";
  	public static final String ARESIMILARTO_SUCCESSFULCONFLICTSET="successfulConflictSet";
  	public static final String ARESIMILARTO="AreSimilarTo";
    public static final String ISNEGATIVE_CASE="case";
    public static final String ISNEGATIVE="IsNegative";
    public static final String ISPOSITIVE_CASE="case";
    public static final String ISPOSITIVE="IsPositive";
    public static final String ISTHEMOSTREASONABLETO_PROBLEM="problem";
    public static final String ISTHEMOSTREASONABLETO_PROPOSEDSOLUTION="proposedSolution";
    public static final String ISTHEMOSTREASONABLETO="IsTheMostReasonableTo";
    public static final String AREREASONABLESOLUTIONSTO_PROPOSEDSOLUTIONS="proposedSolutions";
    public static final String AREREASONABLESOLUTIONSTO_PROBLEM="problem";
    public static final String AREREASONABLESOLUTIONSTO="AreReasonableSolutionsTo";
    public static final String RETRIEVE_SIMILARTO="similarTo";
    public static final String RETRIEVE="Retrieve";
    public static final String DESCRIBES="Describes";
    public static final String ADAPT_FAILURECONFLICTSET="failureConflictSet";
    public static final String ADAPT_SUCCESSFULCONFLICTSET="successfulConflictSet";
    public static final String ADAPT_TO="to";
    public static final String ADAPT="Adapt";
    public static final String RESOLVE_PROBLEM="problem";
    public static final String RESOLVE="Resolve";
    public static final String RETAIN_CASE="case";
    public static final String RETAIN="Retain";
    public static final String HYPOTHESIS_UNMATCHEDDESCRIPTION="unmatchedDescription";
    public static final String HYPOTHESIS_DESCRIPTION="description";
    public static final String HYPOTHESIS_JUSTIFICATION="justification";
    public static final String HYPOTHESIS_POSSIBLESOLUTIONS="possibleSolutions";
    public static final String HYPOTHESIS="Hypothesis";
    public static final String CASE_STATE="state";
    public static final String CASE_PROBLEM="problem";
    public static final String CASE_SOLUTION="solution";
    public static final String CASE="Case";
    public static final String PROBLEM_LEASTSIMILARITYDEGREE="leastSimilarityDegree";
    public static final String PROBLEM_GOALRANK="goalRank";
    public static final String PROBLEM_DESCRIPTION="description";
    public static final String PROBLEM="Problem";
    public static final String SOLUTION_NAME="taxonName";
    public static final String SOLUTION_JUSTIFICATION="justification";
    public static final String SOLUTION_RANK="taxonLevel";
    public static final String SOLUTION="Solution";
    public static final String POSSIBLESOLUTION_CONTRADICTIONS="contradictions";
    public static final String POSSIBLESOLUTION_DOUBTFULDESCRIPTION="doubtfulDescription";
    public static final String POSSIBLESOLUTION_SOLUTIONDESCRIPTION="solutionDescription";
    public static final String POSSIBLESOLUTION_UNCONFIRMEDDESCRIPTION="unconfirmedDescription";
    public static final String POSSIBLESOLUTION_SOLUTION="solution";
    public static final String POSSIBLESOLUTION_CONFIRMEDDESCRIPTION="confirmedDescription";
    public static final String POSSIBLESOLUTION_POINTS="points";
    public static final String POSSIBLESOLUTION="PossibleSolution";
    public static final String PROPOSEDSOLUTION_STATE="state";
    public static final String PROPOSEDSOLUTION_SOLUTION="solution";
    public static final String PROPOSEDSOLUTION_CERTAINTYDEGREE="certaintyDegree";
    public static final String PROPOSEDSOLUTION="ProposedSolution";
    public static final String AREEVALUATEDSOLUTIONSTO_FAILURECONFLICTSET="failureConflictSet";
    public static final String AREEVALUATEDSOLUTIONSTO_SUCCESSFULCONFLICTSET="successfulConflictSet";
    public static final String AREEVALUATEDSOLUTIONSTO_TO="to";
    public static final String AREEVALUATEDSOLUTIONSTO="AreEvaluatedSolutionsTo";
    public static final String ARESELECTEDSOLUTIONSTO_PROPOSEDSOLUTIONS="proposedSolutions";
    public static final String ARESELECTEDSOLUTIONSTO_TO="to";
    public static final String ARESELECTEDSOLUTIONSTO="AreSelectedSolutionsTo";
    public static final String SELECT_FAILURECONFLICTSET="failureConflictSet";
    public static final String SELECT_SUCCESSFULCONFLICTSET="successfulConflictSet";
    public static final String SELECT_TO="to";
    public static final String SELECT="Select";
    public static final String EVALUATE_FAILURECONFLICTSET="failureConflictSet";
    public static final String EVALUATE_SUCCESSFULCONFLICTSET="successfulConflictSet";
    public static final String EVALUATE_TO="to";
    public static final String EVALUATE="Evaluate";

  /**
   * Constructor
  */
  private CBRTerminologyOntology(){ 
    super(ONTOLOGY_NAME, TaxonomyOntology.getInstance(), new MicroIntrospector());
    try { 

    ConceptSchema proposedSolutionSchema = new ConceptSchema(PROPOSEDSOLUTION);
    add(proposedSolutionSchema, Class.forName("ontology.CBR.ProposedSolution"));
    ConceptSchema possibleSolutionSchema = new ConceptSchema(POSSIBLESOLUTION);
    add(possibleSolutionSchema, Class.forName("ontology.CBR.PossibleSolution"));
    ConceptSchema solutionSchema = new ConceptSchema(SOLUTION);
    add(solutionSchema, Class.forName("ontology.CBR.Solution"));
    ConceptSchema problemSchema = new ConceptSchema(PROBLEM);
    add(problemSchema, Class.forName("ontology.CBR.Problem"));
    ConceptSchema caseSchema = new ConceptSchema(CASE);
    add(caseSchema, Class.forName("ontology.CBR.Case"));
    ConceptSchema hypothesisSchema = new ConceptSchema(HYPOTHESIS);
    add(hypothesisSchema, Class.forName("ontology.CBR.Hypothesis"));

    // adding AgentAction(s)
    AgentActionSchema retrieveSchema = new AgentActionSchema(RETRIEVE);
    add(retrieveSchema, Class.forName("ontology.CBR.Retrieve"));
    AgentActionSchema adaptSchema = new AgentActionSchema(ADAPT);
    add(adaptSchema, Class.forName("ontology.CBR.Adapt"));
    AgentActionSchema evaluateSchema = new AgentActionSchema(EVALUATE);
    add(evaluateSchema, Class.forName("ontology.CBR.Evaluate"));
    AgentActionSchema selectSchema = new AgentActionSchema(SELECT);
    add(selectSchema, Class.forName("ontology.CBR.Select"));
    AgentActionSchema resolveSchema = new AgentActionSchema(RESOLVE);
    add(resolveSchema, Class.forName("ontology.CBR.Resolve"));
    AgentActionSchema retainSchema = new AgentActionSchema(RETAIN);
    add(retainSchema, Class.forName("ontology.CBR.Retain"));

    // adding AID(s)

    // adding Predicate(s)
    PredicateSchema areReasonableSolutionsToSchema = new PredicateSchema(AREREASONABLESOLUTIONSTO);
    add(areReasonableSolutionsToSchema, Class.forName("ontology.CBR.AreReasonableSolutionsTo"));
    PredicateSchema isTheMostReasonableToSchema = new PredicateSchema(ISTHEMOSTREASONABLETO);
    add(isTheMostReasonableToSchema, Class.forName("ontology.CBR.IsTheMostReasonableTo"));
    PredicateSchema isPositiveSchema = new PredicateSchema(ISPOSITIVE);
    add(isPositiveSchema, Class.forName("ontology.CBR.IsPositive"));
    PredicateSchema isNegativeSchema = new PredicateSchema(ISNEGATIVE);
    add(isNegativeSchema, Class.forName("ontology.CBR.IsNegative"));
    PredicateSchema areSimilarToSchema = new PredicateSchema(ARESIMILARTO);
    add(areSimilarToSchema, Class.forName("ontology.CBR.AreSimilarTo"));
    PredicateSchema areEvaluatedSolutionsToSchema = new PredicateSchema(AREEVALUATEDSOLUTIONSTO);
    add(areEvaluatedSolutionsToSchema, Class.forName("ontology.CBR.AreEvaluatedSolutionsTo"));
    PredicateSchema areSelectedSolutionsToSchema = new PredicateSchema(ARESELECTEDSOLUTIONSTO);
    add(areSelectedSolutionsToSchema, Class.forName("ontology.CBR.AreSelectedSolutionsTo"));


    // adding fields
    proposedSolutionSchema.add(PROPOSEDSOLUTION_CERTAINTYDEGREE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    proposedSolutionSchema.add(PROPOSEDSOLUTION_SOLUTION, possibleSolutionSchema, ObjectSchema.MANDATORY);
    proposedSolutionSchema.add(PROPOSEDSOLUTION_STATE, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.MANDATORY);
    possibleSolutionSchema.add(POSSIBLESOLUTION_POINTS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    possibleSolutionSchema.add(POSSIBLESOLUTION_CONFIRMEDDESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    possibleSolutionSchema.add(POSSIBLESOLUTION_SOLUTION, new ConceptSchema("Concept"), ObjectSchema.MANDATORY);
    possibleSolutionSchema.add(POSSIBLESOLUTION_UNCONFIRMEDDESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    possibleSolutionSchema.add(POSSIBLESOLUTION_SOLUTIONDESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.MANDATORY);
    possibleSolutionSchema.add(POSSIBLESOLUTION_DOUBTFULDESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    possibleSolutionSchema.add(POSSIBLESOLUTION_CONTRADICTIONS, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    solutionSchema.add(SOLUTION_RANK, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    solutionSchema.add(SOLUTION_JUSTIFICATION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    solutionSchema.add(SOLUTION_NAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    problemSchema.add(PROBLEM_DESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.MANDATORY);
    problemSchema.add(PROBLEM_GOALRANK, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    problemSchema.add(PROBLEM_LEASTSIMILARITYDEGREE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    caseSchema.add(CASE_SOLUTION, solutionSchema, ObjectSchema.MANDATORY);
    caseSchema.add(CASE_PROBLEM, problemSchema, ObjectSchema.MANDATORY);
    caseSchema.add(CASE_STATE, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.MANDATORY);
    hypothesisSchema.add(HYPOTHESIS_POSSIBLESOLUTIONS, possibleSolutionSchema, 1, ObjectSchema.UNLIMITED);
    hypothesisSchema.add(HYPOTHESIS_JUSTIFICATION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    hypothesisSchema.add(HYPOTHESIS_DESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.MANDATORY);
    hypothesisSchema.add(HYPOTHESIS_UNMATCHEDDESCRIPTION, (ConceptSchema) getSchema(CommonTerminologyOntology.DESCRIPTION), ObjectSchema.OPTIONAL);
    retainSchema.add(RETAIN_CASE, caseSchema, ObjectSchema.MANDATORY);
    resolveSchema.add(RESOLVE_PROBLEM, problemSchema, ObjectSchema.MANDATORY);
    adaptSchema.add(ADAPT_SUCCESSFULCONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    adaptSchema.add(ADAPT_FAILURECONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    adaptSchema.add(ADAPT_TO, problemSchema, ObjectSchema.MANDATORY);
    retrieveSchema.add(RETRIEVE_SIMILARTO, problemSchema, ObjectSchema.MANDATORY);
    areReasonableSolutionsToSchema.add(AREREASONABLESOLUTIONSTO_PROBLEM, problemSchema, ObjectSchema.MANDATORY);
    areReasonableSolutionsToSchema.add(AREREASONABLESOLUTIONSTO_PROPOSEDSOLUTIONS, proposedSolutionSchema, 0, ObjectSchema.UNLIMITED);
    isTheMostReasonableToSchema.add(ISTHEMOSTREASONABLETO_PROPOSEDSOLUTION, proposedSolutionSchema, ObjectSchema.MANDATORY);
    isTheMostReasonableToSchema.add(ISTHEMOSTREASONABLETO_PROBLEM, problemSchema, ObjectSchema.MANDATORY);
    isPositiveSchema.add(ISPOSITIVE_CASE, caseSchema, ObjectSchema.MANDATORY);
    isNegativeSchema.add(ISNEGATIVE_CASE, caseSchema, ObjectSchema.MANDATORY);
    areReasonableSolutionsToSchema.add(AREREASONABLESOLUTIONSTO_PROBLEM, problemSchema, ObjectSchema.MANDATORY);
    areSimilarToSchema.add(ARESIMILARTO_SUCCESSFULCONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    areSimilarToSchema.add(ARESIMILARTO_FAILURECONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    areSimilarToSchema.add(ARESIMILARTO_PROBLEM, problemSchema, ObjectSchema.MANDATORY);
    evaluateSchema.add(EVALUATE_TO, problemSchema, ObjectSchema.MANDATORY);
    evaluateSchema.add(EVALUATE_SUCCESSFULCONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    evaluateSchema.add(EVALUATE_FAILURECONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    selectSchema.add(SELECT_TO, problemSchema, ObjectSchema.MANDATORY);
    selectSchema.add(SELECT_SUCCESSFULCONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    selectSchema.add(SELECT_FAILURECONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    areEvaluatedSolutionsToSchema.add(AREEVALUATEDSOLUTIONSTO_TO, problemSchema, ObjectSchema.MANDATORY);
    areEvaluatedSolutionsToSchema.add(AREEVALUATEDSOLUTIONSTO_SUCCESSFULCONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    areEvaluatedSolutionsToSchema.add(AREEVALUATEDSOLUTIONSTO_FAILURECONFLICTSET, hypothesisSchema, 0, ObjectSchema.UNLIMITED);
    areSelectedSolutionsToSchema.add(ARESELECTEDSOLUTIONSTO_TO, problemSchema, ObjectSchema.MANDATORY);
    areSelectedSolutionsToSchema.add(ARESELECTEDSOLUTIONSTO_PROPOSEDSOLUTIONS, proposedSolutionSchema, 1, ObjectSchema.UNLIMITED);

    // adding name mappings

    // adding inheritance
    
   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
}
