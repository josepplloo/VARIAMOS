package com.variamos.refas.core.sematicsmetamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.variamos.syntaxsupport.metamodelsupport.AbstractAttribute;
import com.variamos.syntaxsupport.metamodelsupport.MetaExtends;
import com.variamos.syntaxsupport.metamodelsupport.SemanticAttribute;
import com.variamos.syntaxsupport.metamodelsupport.SimulationStateAttribute;
import com.variamos.syntaxsupport.semanticinterface.IntSemanticConcept;

/**
 * A class to represent the vertex at semantic level. Part of PhD work at
 * University of Paris 1
 * 
 * @author Juan C. Mu�oz Fern�ndez <jcmunoz@gmail.com>
 * 
 * @version 1.1
 * @since 2014-11-23
 */
public abstract class AbstractSemanticVertex extends AbstractSemanticElement implements
		IntSemanticConcept {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3569174300072453550L;

	private boolean booleanSatisfaction;

	private List<IncomingSemanticEdge> groupRelations = new ArrayList<IncomingSemanticEdge>();
	private List<SemanticPairwiseRelation> directRelations = new ArrayList<SemanticPairwiseRelation>();

	public AbstractSemanticVertex() {
		this(null, "", false, new ArrayList<String>(), new ArrayList<String>(),
				new ArrayList<String>(), new ArrayList<String>());
	}
	
	public AbstractSemanticVertex(String identifier) {
		super(identifier);
	}
	
	
	public AbstractSemanticVertex(AbstractSemanticElement parentConcept, String identifier) {
		super(parentConcept, identifier);
	}

	public AbstractSemanticVertex(AbstractSemanticVertex parentConcept,
			String name, boolean satisfactionType) {
		this(parentConcept, name, satisfactionType, new ArrayList<String>(),
				new ArrayList<String>(), new ArrayList<String>(),
				new ArrayList<String>());
		if (getParent() != null) {
			groupRelations.addAll(parentConcept.getgroupRelations());
			directRelations.addAll(parentConcept.getDirectRelations());
		} else {
			groupRelations = new ArrayList<IncomingSemanticEdge>();
			directRelations = new ArrayList<SemanticPairwiseRelation>();
		}	}

	public AbstractSemanticVertex(String name, boolean satisfactionType) {
		this(null, name, satisfactionType, new ArrayList<String>(),
				new ArrayList<String>(), new ArrayList<String>(),
				new ArrayList<String>());
	}

	public AbstractSemanticVertex(AbstractSemanticVertex parentConcept,
			String identifier, boolean satisfactionType,
			List<String> disPropVisibleAttributes,
			List<String> disPropEditableAttributes,
			List<String> disPanelVisibleAttributes,
			List<String> disPanelSpacersAttributes) {
		super(parentConcept, identifier, disPropVisibleAttributes,
				disPropEditableAttributes, disPanelVisibleAttributes,
				disPanelSpacersAttributes);
		this.booleanSatisfaction = satisfactionType;
		if (getParent() != null) {
			groupRelations.addAll(parentConcept.getgroupRelations());
			directRelations.addAll(parentConcept.getDirectRelations());
		} else {
			groupRelations = new ArrayList<IncomingSemanticEdge>();
			directRelations = new ArrayList<SemanticPairwiseRelation>();
		}
	}

	public boolean isBooleanSatisfaction() {
		return booleanSatisfaction;
	}

	public void setBooleanSatisfaction(boolean booleanSatisfaction) {
		this.booleanSatisfaction = booleanSatisfaction;
	}

	public List<IncomingSemanticEdge> getGroupRelations() {
		return groupRelations;
	}

	public void setGroupRelations(List<IncomingSemanticEdge> groupRelations) {
		this.groupRelations = groupRelations;
	}

	public void setDirectRelations(List<SemanticPairwiseRelation> directRelations) {
		this.directRelations = directRelations;
	}

	public List<IncomingSemanticEdge> getgroupRelations() {
		return groupRelations;
	}

	public List<SemanticPairwiseRelation> getDirectRelations() {
		return directRelations;
	}

	public void addGroupRelation(IncomingSemanticEdge groupRelation) {
		groupRelations.add(groupRelation);
	}

	public void addDirectRelation(SemanticPairwiseRelation directRelation) {
		directRelations.add(directRelation);
	}

	public String toString() {
		/*
		 * String directRelationsOut = ""; for (int i = 0; i<
		 * directRelations.size();i++) directRelationsOut +=
		 * directRelations.get(i).getType()+", "; String groupRelationsOut = "";
		 * for (int i = 0; i< groupRelations.size();i++) groupRelationsOut +=
		 * groupRelations.get(i).toString()+", ";
		 */
		return "name : " + getIdentifier() + " booleanSatisf: "
				+ booleanSatisfaction + " multirel: " /*
													 * + multipleGroupRelations
													 * + " dirRel: " +
													 * directRelationsOut +
													 * " dirRel: " +
													 * groupRelationsOut
													 */;
	}
}
