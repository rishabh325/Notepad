 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_notepad;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;
import static sun.security.x509.OIDMap.getClass;
import static sun.security.x509.OIDMap.getClass;
/**
 *
 * @author Aman
 */
public class Java_notepad extends JFrame {
    
    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String fstyle="Arial";
     String filecontent=null;
    public JTextArea mainarea;
    JMenuBar mbar;
    JMenu mnuFile,mnuEdit,mnuFormat,mnuView,mnuHelp;
    JMenuItem itmNew,itmFontColor,itmFontSize,itmFontStyle,itmFontFace ,itmOpen,itmAbout, itmSave, itmSaveas,itmBg, itmPgsetup, itmPrint, itmExit, itmUndo, itmCut, itmCopy,itmFont, itmPaste, itmDelete, itmReplace, itmFind, itmFindnext;
    String filename;
    JFileChooser jc;
    UndoManager undo;
    UndoAction undoAction;
    RedoAction redoAction;
    JCheckBoxMenuItem wordWrap;
   JToolBar toolbar;
   JToolBar toolbar2;
    JButton btnOpen;
    JButton btnNew;
    JButton btnSave;
    JButton btnPage;
    JButton btnPrint;
   // JButton btnUndo;
    JButton btnRedo;
    JButton btnCut;
    JButton btnCopy;
    JButton btnPaste;
    JButton btnDelete;
    JButton btnFind;
    JButton btnReplace;
    JButton btnFontColor;
    JButton btnBg;
    //JButton btnFontSize;
    //JButton btnFontStyle;
    //JButton btnFontFace;
    JButton udl,bold,italic,bold_it,plain;
    int fsize=12;
    int fface=0;
    //JButton btnWord;
    // FontHelper font;
    //start
    JPanel pan1,pan2,pan3;
 JLabel fontLabel,sizeLabel,previewLabel,typeLabel;
 JTextField label,fontText,sizeText,typeText;
 JScrollPane fontScroll,sizeScroll,typeScroll;
 JList fontList,sizeList,typeList;
 JButton ok,cancel;
 JComboBox comboBox,comboBox1;
 
// FontHelper font;
//end
    public Java_notepad(){
        
        initComponent();
       /*  FontSize f=new FontSize();*/
        itmSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save();
                } catch (IOException ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save();
                } catch (IOException ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         itmSaveas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveas();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          itmOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    open();
                } catch (IOException ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btnOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    open();
                } catch (IOException ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
   
          itmNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    neww();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btnNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    neww();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           itmExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {if(/*mainarea.getText().equals(null)*//*mainarea.getText().equals(filecontent)||*/!(mainarea.getText().equals(null))){
                System.exit(0);}
                else{
                    saveas();
                    System.exit(0);
                }
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           
           itmCut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.cut();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           btnCut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.cut();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           itmCopy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.copy();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           btnCopy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.copy();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          
  /*          itmFont.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                font=new FontHelper();
                font.setVisible(true);
            }
        });
           /*  font.getOk().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.setFont(font.font());
                font.setVisible(false);
            }
        });
             font.getCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                font.setVisible(false);
            }
        });*/
           itmPaste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.paste();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           itmDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.setText(null);
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.setText(null);
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
           
              btnPaste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainarea.paste();
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
           
            itmUndo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   mainarea.getDocument().addUndoableEditListener(new UndoableEditListener() {

            @Override
               public void undoableEditHappened(UndoableEditEvent e) {
                   undo.addEdit(e.getEdit());
                   undoAction.update();
                   undoAction.update();
               }
        });
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
            mainarea.getDocument().addUndoableEditListener(new UndoableEditListener() {

            @Override
               public void undoableEditHappened(UndoableEditEvent e) {
                   if(mainarea.getText().equals(filecontent))
                   itmSave.setEnabled(false);
                   else
                       itmSave.setEnabled(true);
                   undo.addEdit(e.getEdit());
                   undoAction.update();
                   undoAction.update();
               }
        });
          
           wordWrap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if(wordWrap.isSelected()){
                 mainarea.setLineWrap(true);
               mainarea.setWrapStyleWord(true);
               }
               else{
                   mainarea.setLineWrap(false);
               mainarea.setWrapStyleWord(false);
               }
            }
        });
           
            itmFontColor.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(rootPane,"Choose Font Color",Color.yellow);
                mainarea.setForeground(c);
            }
        });
            btnFontColor.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(rootPane,"Choose Font Color",Color.yellow);
                mainarea.setForeground(c);
            }
        });
             itmBg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(rootPane,"Choose Font Color",Color.white);
                
                mainarea.setBackground(c);
            }
        });
              btnBg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(rootPane,"Choose Font Color",Color.white);
                mainarea.setBackground(c);
            }
        });
           
              comboBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 String item=(String) comboBox.getSelectedItem();
                 fsize=Integer.parseInt(item);
                 mainarea.setFont(new Font(fstyle,fface,fsize));

            }
                
                            
        });
              comboBox1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 String item=(String) comboBox1.getSelectedItem();
                if(!fstyle.equals(item))
                    fstyle=item;
                 //fsize=Integer.parseInt(item);
                 mainarea.setFont(new Font(fstyle,fface,fsize));

            }
                
                            
        });
      /* b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if(wordWrap.isSelected()){
                 mainarea.setLineWrap(true);
               mainarea.setWrapStyleWord(true);
               }
               else{
                   mainarea.setLineWrap(false);
               mainarea.setWrapStyleWord(false);
               }
            }
        });
 */
               italic.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fface=2;
                    mainarea.setFont(new Font(fstyle,fface,fsize));
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                bold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fface=1;
                    mainarea.setFont(new Font(fstyle,fface,fsize));
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                 bold_it.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fface=3;
                    mainarea.setFont(new Font(fstyle,fface,fsize));
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                  plain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fface=0;
                    mainarea.setFont(new Font(fstyle,fface,fsize));
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                              udl.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  // mainarea.setFont()
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
          itmAbout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    about abt=new about();
                    abt.setVisible(true);
                  // mainarea.setFont()
                } catch (Exception ex) {
                    Logger.getLogger(Java_notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });        
                 
    }
    
   
private void initComponent(){
    //font=new FontHelper();
    jc = new JFileChooser(".");
    mainarea = new JTextArea();
    undo = new UndoManager();
    ImageIcon undoIcon=new ImageIcon(getClass().getResource("/folder/undo.png"));
    ImageIcon redoIcon=new ImageIcon(getClass().getResource("/folder/redo.png"));
    undoAction=new UndoAction(undoIcon);
    redoAction=new RedoAction(redoIcon);
    toolbar=new JToolBar();
    toolbar2=new JToolBar();
     
   getContentPane().add(toolbar,BorderLayout.NORTH);
    getContentPane().add(toolbar2,BorderLayout.SOUTH);
    getContentPane().add(mainarea);
    getContentPane().add(new JScrollPane(mainarea), BorderLayout.CENTER);
    setTitle("Untitled-Notepad");
    setSize(800, 600);
    mbar = new JMenuBar();
    mnuFile=new JMenu("File");
    mnuEdit=new JMenu("Edit");
    mnuFormat=new JMenu("Format");
    mnuView=new JMenu("View");
    mnuHelp=new JMenu("Help");
    ImageIcon openIcon=new ImageIcon(getClass().getResource("/folder/open_1.png"));
    ImageIcon newIcon=new ImageIcon(getClass().getResource("/folder/New.png"));
    ImageIcon copyIcon=new ImageIcon(getClass().getResource("/folder/copy.png"));
    ImageIcon cutIcon=new ImageIcon(getClass().getResource("/folder/cut2.png"));
    ImageIcon deleteIcon=new ImageIcon(getClass().getResource("/folder/delete.png"));
    ImageIcon findIcon=new ImageIcon(getClass().getResource("/folder/find.png"));
    ImageIcon fontColorIcon=new ImageIcon(getClass().getResource("/folder/font3.png"));
   // ImageIcon imageIcon=new ImageIcon(getClass().getResource("/folder/image.png"));
    ImageIcon pagesetupIcon=new ImageIcon(getClass().getResource("/folder/page_setup.png"));
    ImageIcon pasteIcon=new ImageIcon(getClass().getResource("/folder/paste.png"));
    ImageIcon sizeIcon=new ImageIcon(getClass().getResource("/folder/fsize.png"));
    ImageIcon faceIcon=new ImageIcon(getClass().getResource("/folder/fface.png"));
    ImageIcon styleIcon=new ImageIcon(getClass().getResource("/folder/fstyle.png"));
    ImageIcon replaceIcon=new ImageIcon(getClass().getResource("/folder/replace.png"));
    ImageIcon saveIcon=new ImageIcon(getClass().getResource("/folder/save.png"));
    ImageIcon wordIcon=new ImageIcon(getClass().getResource("/folder/word.png"));
    ImageIcon printIcon=new ImageIcon(getClass().getResource("/folder/cut.png"));
    ImageIcon bgIcon=new ImageIcon(getClass().getResource("/folder/font2.png"));
    ImageIcon udlIcon=new ImageIcon(getClass().getResource("/folder/udl.png"));
    ImageIcon boldIcon=new ImageIcon(getClass().getResource("/folder/bold.png"));
    ImageIcon italicIcon=new ImageIcon(getClass().getResource("/folder/italic.png"));
    ImageIcon bolditIcon=new ImageIcon(getClass().getResource("/folder/boldit.png"));
    ImageIcon plainIcon=new ImageIcon(getClass().getResource("/folder/plain.png"));
    
    itmNew=new JMenuItem("New",newIcon);
    itmOpen=new JMenuItem("Open",openIcon);
    itmSave=new JMenuItem("Save",saveIcon);
    itmFont=new JMenuItem("Font");
    itmSaveas=new JMenuItem("SaveAs...");
    itmPgsetup=new JMenuItem("PageSetup...",pagesetupIcon);
    itmPrint=new JMenuItem("Print...",printIcon);
    itmExit=new JMenuItem("Exit");
    itmUndo=new JMenuItem("Undo",undoIcon);
    itmCut=new JMenuItem("Cut",cutIcon);
    itmCopy=new JMenuItem("Copy",copyIcon);
    itmPaste=new JMenuItem("Paste",pasteIcon);
    itmDelete=new JMenuItem("Delete",deleteIcon);
    itmFind=new JMenuItem("Find...",findIcon);
    itmFindnext=new JMenuItem("Find Next    ");
    itmReplace=new JMenuItem("Replace",replaceIcon);
    wordWrap=new JCheckBoxMenuItem("WordWrap",wordIcon);
    itmFontColor=new JMenuItem("Font Color",fontColorIcon);
    itmFontSize=new JMenuItem("Font Size",sizeIcon);
    itmFontStyle=new JMenuItem("Font Style",styleIcon);
    itmFontFace=new JMenuItem("Font Face",faceIcon);
    itmBg=new JMenuItem("Background",bgIcon);
    itmAbout=new JMenuItem("About Notepad");
    comboBox=new javax.swing.JComboBox();
    comboBox1=new javax.swing.JComboBox();
    //layout.setHorizontalGroup(addComponent(comboBox, 0, 10, Short.MAX_VALUE));
    comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "10", "12", "16", "18", "20", "24", "28", "32", "48", "72" }));
     comboBox1.setModel(new javax.swing.DefaultComboBoxModel(fonts));
   // itmFont=new JMenuItem("Font Color",fontIcon);
    itmNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
    itmSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    itmOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
    itmPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    //undoAction.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
    //redoAction.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
    itmCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
    itmPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
    itmFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
    itmReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    itmDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE,0));
    itmFindnext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3,0));
    itmUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
    //itmDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE,0));
   
    mnuFile.add(itmNew);
    mnuFile.add(itmOpen);
    mnuFile.add(itmSave);
    mnuFile.add(itmSaveas);
    mnuFile.add(itmPgsetup);
    mnuFile.add(itmPrint);
    mnuFile.add(itmExit);
    mnuEdit.add(undoAction);
    mnuEdit.add(redoAction);
    mnuEdit.add(itmCut);
    mnuEdit.add(itmCopy);
    mnuEdit.add(itmPaste);
    mnuEdit.add(itmDelete);
    mnuEdit.add(itmFind);
    mnuEdit.add(itmFindnext);
    mnuEdit.add(itmReplace);
    //mnuEdit.add(itmFont);
    mnuFormat.add(wordWrap);
    mnuFormat.add(itmFontColor);
    mnuHelp.add(itmAbout);
   // mnuFormat.add(itmFontSize);
   // mnuFormat.add(itmFontStyle);
    //mnuFormat.add(itmFontFace);
    mnuView.add(itmBg);
    mbar.add(mnuFile/*,newI*/);
     mbar.add(mnuEdit);
    mbar.add(mnuFormat);
    mbar.add(mnuView);
    mbar.add(mnuHelp);
    setJMenuBar(mbar);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    btnOpen=new JButton(openIcon);
     btnNew=new JButton(newIcon);
    btnSave=new JButton(saveIcon);
    btnPage=new JButton(pagesetupIcon);
    btnPrint=new JButton(printIcon);
    //btnUndo=new JButton(undoIcon);
    //btnRedo=new JButton(redoIcon);
    btnCut=new JButton(cutIcon);
    btnCopy=new JButton(copyIcon);
    btnPaste=new JButton(pasteIcon);
     btnDelete=new JButton(deleteIcon);
     btnFind=new JButton(findIcon);
    btnReplace=new JButton(replaceIcon);
    btnFontColor=new JButton(fontColorIcon);
   // btnWord = new JButton(wordIcon);
    btnBg=new JButton(bgIcon);
//    btnFontFace=new JButton(faceIcon);
  //  btnFontStyle=new JButton(styleIcon);
    //btnFontSize=new JButton(sizeIcon);
       udl=new JButton(udlIcon);
    italic=new JButton(italicIcon);
    bold=new JButton(boldIcon);
    bold_it=new JButton(bolditIcon);
    plain=new JButton(plainIcon);
    toolbar.add(comboBox);
    toolbar.add(comboBox1);
    toolbar.add(btnNew);
    toolbar.add(btnOpen);
    toolbar.add(btnSave);
    toolbar.add(btnPage);
    toolbar.add(btnPrint);
    
    toolbar.add(udl);
    toolbar.add(italic);
    toolbar.add(bold);
        toolbar.add(bold_it);
        toolbar.add(plain);

    
    //toolbar2.add(btnUndo);
    //toolbar2.add(btnRedo);
    toolbar2.add(btnCut);
    toolbar2.add(btnCopy);
    toolbar2.add(btnPaste);
    toolbar2.add(btnDelete);
    toolbar2.add(btnFind);
    toolbar2.add(btnReplace);
    toolbar2.add(btnFontColor);
    //toolbar2.add(btnFontSize);
    //toolbar2.add(btnFontStyle);
   // toolbar2.add(btnFontFace);
    toolbar2.add(btnBg);
    //toolbar2.add(btnWord);
     
}
public void save() throws IOException{
    PrintWriter fout=null;
    int retval =-1;
    try {
        if(filename=="Untitled-Notepad" ||filename==null ){
            retval=jc.showSaveDialog(this);
        if(retval==jc.APPROVE_OPTION){
         fout=new PrintWriter(new FileWriter(jc.getSelectedFile()));
        
        String s=mainarea.getText();
        StringTokenizer st=new StringTokenizer(s,System.getProperty("line.separator"));
        while(st.hasMoreElements()){
        fout.println(st.nextToken());
        }
        JOptionPane.showMessageDialog(rootPane,"File Saved");
            filecontent = mainarea.getText();
        filename=jc.getSelectedFile().getName();    //setting up title
            setTitle(filename);
        }
        }
        else{
        fout=new PrintWriter(new FileWriter(filename));
         String s=mainarea.getText();
        StringTokenizer st=new StringTokenizer(s,System.getProperty("line.separator"));
        while(st.hasMoreElements()){
        fout.println(st.nextToken());
        }
        JOptionPane.showMessageDialog(rootPane,"File Saved");
         filecontent = mainarea.getText();
        }
        }   
    catch (IOException e) {
    }
    finally{
    fout.close();
    }
}public void saveas() throws Exception{
    PrintWriter fout=null;
    int retval =-1;
    try {
            retval=jc.showSaveDialog(this);
        if(retval==jc.APPROVE_OPTION){
         fout=new PrintWriter(new FileWriter(jc.getSelectedFile()));
        
        String s=mainarea.getText();
        StringTokenizer st=new StringTokenizer(s,System.getProperty("line.separator"));
        while(st.hasMoreElements()){
        fout.println(st.nextToken());
        }
        JOptionPane.showMessageDialog(rootPane,"File Saved");
        filecontent = mainarea.getText();
        filename=jc.getSelectedFile().getName();
            setTitle(filename);}
      //  else{
     //   fout=new PrintWriter(new FileWriter(filename));
      /*   String s=mainarea.getText();
        StringTokenizer st=new StringTokenizer(s,System.getProperty("line.separator"));
        while(st.hasMoreElements()){
        fout.println(st.nextToken());
        }
        JOptionPane.showMessageDialog(rootPane,"File Saved");
        filecontent = mainarea.getText();
        }*/
        }   
    catch (Exception e) {
        System.out.println("Exception");
    }
    finally{
    fout.close();
    }
}
public void neww() throws Exception{
    filename=getTitle();
    if(!mainarea.getText().equals("") && !(mainarea.getText().equals(filecontent))){
       if(filename==null||filename=="Untitled-Notepad"){
        int option = JOptionPane.showConfirmDialog(rootPane,"Do you want to save the changes to Untitled");
        if(option==0){
            saveas();
            clear();
        }
            else{
                clear();    
                    }
       }
        else{
              int option = JOptionPane.showConfirmDialog(rootPane,"Do you want to save the changes to Untitled");  
              if(option==0) {
              save();
                clear();
              }
              else{
              clear();
              }
                }
        }
    else
        clear();
    }
    public void clear(){
    mainarea.setText(null);
        setTitle("Untitled-Notepad");
        filename=null;
        filecontent=null;
    }
public void open()throws IOException{
  try{
     int retval=jc.showOpenDialog(this);
     if(retval==jc.APPROVE_OPTION){
     mainarea.setText(null);
     Reader in;
         in = new FileReader(jc.getSelectedFile());
         char[] buff=new char[10000000];
         int nch;
         filename=jc.getSelectedFile().getName();
         if(!filename.endsWith(".cpp")&&!filename.endsWith(".txt")&&!filename.endsWith(".xml")&&!filename.endsWith(".docx")&&!filename.endsWith(".java"))
         {
             mainarea.setText(filecontent);
             JOptionPane.showMessageDialog(this, "Wrong file type");
         
     //jc.setVisible(false);
     }   
         else
         { while((nch=in.read(buff,0,buff.length))!=-1){
           mainarea.append(new String(buff,0,nch));
     }
         filename=jc.getSelectedFile().getName();//setting up title
            setTitle(filename);
            filecontent=mainarea.getText();
            itmSave.setEnabled(false);
     }}
     
  }
  catch(IOException ex){
   ex.printStackTrace();
  }
}

class UndoAction extends AbstractAction{

        public UndoAction(ImageIcon undoIcon) {
            super("Undo",undoIcon);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                ex.printStackTrace();
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       update();
       redoAction.update();
        }

        protected void update(){
            if((mainarea.getText()).equals(filecontent))
                   itmSave.setEnabled(false);
                   else
                       itmSave.setEnabled(true);
            if(undo.canUndo()){
                setEnabled(true);
            putValue(Action.NAME, "Undo");
            }
             else{
             setEnabled(false);
             putValue(Action.NAME, "Undo");
         }
        }
}
class RedoAction extends AbstractAction{

        public RedoAction(ImageIcon redoIcon) {
            super("Redo",redoIcon);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undo.redo();
            } catch (CannotRedoException ex) {
                ex.printStackTrace();
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       update();
       undoAction.update();
        }

        protected void update(){
            
         if(undo.canRedo()){
                 
                setEnabled(true);
            putValue(Action.NAME, "Redo");
         }
         else{
             
             setEnabled(false);
             putValue(Action.NAME, "Redo");
         }
        }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try{
            
        Java_notepad jn=new Java_notepad();
        }
        catch(Exception ex){
        System.out.println("Exception Handling");
        }
        // TODO code application logic here
    }

    
}
