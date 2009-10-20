/**
 * @see "Categor�a Sukia Domain Theory de SUKIA Smalltalk"
 */
package ontology.taxonomy;

import jade.util.leap.ArrayList;
import jade.util.leap.List;

/**
 * The first level MUST always be ROOT. All other level names MUST be added
 * according to their hierarchical ordering.  Thus, the second name in the list represents the MOST general
 * taxonomic rank, while the last name represents the most specific taxonomic rank.
 * PRECONDITION: There must be at least two taxonomic level names: ROOR + aTaxonomicLevelName.
 * @see "M�todo initialize del protocolo de clase class initialization en SUKIA SmallTalk"
 * @author Armando
 *
 */
public class TaxonomicRank {
	/**
	 * Constantes de la enumeraci&oacute;n
	 */

        public static String ROOT = "Root";
        public static String FAMILY = "Family";
        public static String GENUS = "Genus";
        public static String SPECIES = "Species";
        public static List values;

        static {
            values = new ArrayList();
            values.add(ROOT);
            values.add(FAMILY);
            values.add(GENUS);
            values.add(SPECIES);
        }
	/**
	 * Variable para manejar el valor de la constante
	 */
	private final String rank;
	
	/**
	 * Contructor de la enumeraci&oacute;n
	 * @param similaryDegree
	 */
	TaxonomicRank(String rank) {
		this.rank = rank; 
	}
	
	/**
	 * M&eacute;todo accesor de lectura
	 * @return
	 */
	public String getRank() {
		return rank;
	}
		
	/**
	 * Returns the most general taxonomic rank name, which always must be the second name in the enumeration
	 * (i.e., the taxonomic hierarchy)
	 * @see "M�todo mostGeneralLevel del protocolo de clase accessing en SUKIA SmallTalk"
	 * @return
	 */
	public static String getMostGeneralRank() {
		return TaxonomicRank.FAMILY;
	}
	
	/**
	 * Returns the most specific taxonomic rank name, which always must be the last name in the enumeration
	 * (i.e., the taxonomic hierarchy)
	 * @see "M�todo mostSpecificLevel del protocolo de clase accessing en SUKIA SmallTalk"
	 * @return
	 */
	public static String getMostSpecificLevel() {
		return TaxonomicRank.SPECIES;
	}

	/**
	 * Three taxonomic levels for this implementation: 1 - family; 2 - genus; 3 - species
	 * @see "M�todo nomenclaturalNumber del protocolo de clase class messages en SUKIA SmallTalk"
	 */
	public static int getNomenclaturalRanksNumber() {
		return (TaxonomicRank.values.size() - 1);
	}
	
	/**
	 * Four taxonomic levels for this implementation: 0 - root; 1 - family; 2 - genus; 3 - species
	 * @see "M�todo totalNumber del protocolo de clase class messages en SUKIA SmallTalk"
	 */
	public static int getTotalRanksNumber() {
		return TaxonomicRank.values.size();
	}	
	
	/**
	 * Obtiene el &iacute;ndice que ocupa rank en la enumeraci&oacute;n
	 * @param taxonomicRank
	 * @return el &iacute;ndice que ocupa rank en la enumeraci&oacute;n o -1 si rank no se encontra
	 */
	public static int getIndex(String taxonomicRank) {
		int r = 0;
                if (taxonomicRank == null){return -1;}

                for (int i= 0;i<TaxonomicRank.values.size();i++){
                    if (TaxonomicRank.values.get(i).equals(taxonomicRank))
                    break;
                    r = i;
                }
		return r;
	}
}
