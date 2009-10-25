/*****************************************************************
JADE - Java Agent DEvelopment Framework is a framework to develop
multi-agent systems in compliance with the FIPA specifications.
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

package app;
import jade.MicroBoot;
import jade.core.Agent;
import jade.core.MicroRuntime;
import jade.util.leap.Properties;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

//
//public class Start extends MicroBoot {
//    public static void startAgent(){
//    try {
//        MicroRuntime.startAgent(null, "system.MobileInterfaceAgent", null);
//    }
//        catch (Exception e) {
//        }
//    }
//}
//


public class Start extends MicroBoot implements CommandListener {
  private final Command okCommand = new Command("OK", Command.OK, 1);
  private final Command cancelCommand = new Command("Cancel", Command.CANCEL, 1);
  private Form form;
  private TextField tf;
  private StringItem si;

  public void startApp() throws MIDletStateChangeException {
  	super.startApp();

    form = new Form("Digite su nombre:");
    Display.getDisplay(Agent.midlet).setCurrent(form);
    tf = new TextField(null, null, 32, TextField.ANY);
    form.append(tf);
    si = new StringItem(null, null);
    form.append(si);

    form.addCommand(okCommand);
    form.addCommand(cancelCommand);
    form.setCommandListener(this);
  }

  public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
    if (c == okCommand) {
    	
    		try {
    			si.setText("Arrancando Agente Movil...");
	    		MicroRuntime.startAgent("mobile", "app.MobileInterfaceAgent", null);
    		}
    		catch (Exception e) {
                    System.out.println("Error:" + e);
    		}

   }
    else if (c == cancelCommand) {
    	MicroRuntime.stopJADE();
    }
  }

  protected void customize(Properties p) {
  	p.setProperty("exitwhenempty", "true");
	}

}