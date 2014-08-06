package com.variamos.gui.maineditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.GraphicsEnvironment;
*/











import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.TransferHandler;







import javax.swing.border.Border;

import com.mxgraph.examples.swing.editor.BasicGraphEditor;
import com.mxgraph.examples.swing.editor.EditorToolBar;
/*import com.mxgraph.examples.swing.editor.EditorActions.ColorAction;
import com.mxgraph.examples.swing.editor.EditorActions.FontStyleAction;

import com.mxgraph.examples.swing.editor.EditorActions.KeyValueAction;
import com.mxgraph.examples.swing.editor.EditorActions.PrintAction;
*/
import com.mxgraph.examples.swing.editor.EditorActions.NewAction;
import com.mxgraph.examples.swing.editor.EditorActions.OpenAction;
import com.mxgraph.examples.swing.editor.EditorActions.SaveAction;
import com.mxgraph.examples.swing.editor.EditorActions.HistoryAction;

/*
 * import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxConstants;
*/
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxResources;
//import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphView;

public class PerspectiveToolBar extends JToolBar
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8015443128436394471L;
	private JButton buttons[] = new JButton[3];
	private BasicGraphEditor editor;

	/**
	 * 
	 */
	public PerspectiveToolBar(final BasicGraphEditor editor, int orientation)
	{
		super(orientation);
		this.editor = editor;
		setBackground(new Color(220,220,220));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createEmptyBorder(3, 3, 3, 3), getBorder()));
		setFloatable(false);

		addSeparator();

		JLabel lb ;
		lb = new JLabel("Perspectives:  ");
		add (lb);
		buttons[0] = new JButton(mxResources.get("productLineButton"));
		add (buttons[0]);
		buttons[0].addActionListener(new PerspectiveAction(this));
		buttons[1] = new JButton(mxResources.get("defectAnalyzerButton"));
		//buttons[1].setEnabled(false);
		buttons[0].setSelected(true);
		add (buttons[1]);
		buttons[1].addActionListener(new PerspectiveAction(this));
		buttons[2] = new JButton(mxResources.get("requirementsButton"));
		//buttons[2].setEnabled(false);
		add (buttons[2]);
		buttons[2].addActionListener(new PerspectiveAction(this));
		// Sets the zoom in the zoom combo the current value
	}
	public void updateButtons()
	{
		switch (editor.getPerspective()){
		case 0 :
			buttons[0].setSelected(true);
			buttons[1].setSelected(false);
			buttons[2].setSelected(false);
			editor.setLayout(0);
			break;
		case 1 :
			buttons[0].setSelected(false);
			buttons[1].setSelected(true);
			buttons[2].setSelected(false);
			editor.setLayout(1);
			break;
		case 2 :
			buttons[0].setSelected(false);
			buttons[1].setSelected(false);
			buttons[2].setSelected(true);
			editor.setLayout(2);
			break;
			}
	}
}
