/*****************************************************************
JADE - Java Agent DEvelopment Framework is a framework to develop multi-agent systems in compliance with the FIPA specifications.
Copyright (C) 2000 CSELT S.p.A. 

GNU Lesser General Public License

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation, 
version 2.1 of the License. 

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the
Free Software Foundation, Inc., 59 Temple Place - Suite 330,
Boston, MA  02111-1307, USA.
*****************************************************************/

package monitor;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

  /**
   Javadoc documentation for the file
   @author Francisco Regi, Andrea Soracchi - Universita` di Parma
   <Br>
   <a href="mailto:a_soracchi@libero.it"> Andrea Soracchi(e-mail) </a>
   @version $Date: 2002-12-13 12:40:04 +0100 (ven, 13 dic 2002) $ $Revision: 3524 $
 */

  /**
  * This is the PopupMenu that will appear if the user click
  * on the tree.
  */


public class PopupMenuAgent extends JPopupMenu{

  public PopupMenuAgent(ActionProcessor actPro) {

   super();
   JMenuItem tmp;

   tmp=add((SnifferAction)actPro.actions.get(actPro.DO_SNIFFER_ACTION));
   tmp.setIcon(null);

   tmp=add((SnifferAction)actPro.actions.get(actPro.DO_NOT_SNIFFER_ACTION));
   tmp.setIcon(null);

   tmp=add((SnifferAction)actPro.actions.get(actPro.SWOW_ONLY_ACTION));
   tmp.setIcon(null);
 }

} 