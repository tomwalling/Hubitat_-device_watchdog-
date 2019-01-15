/**
 *  ****************  At Home Simulator Child  ****************
 *
 *  Design Usage:
 *	Turn lights on and off to simulate the appearance of an occupied home using YOUR normal routine.
 *
 *  Copyright 2019 Bryan Turcotte (@bptworld)
 *
 *  Special thanks to (@Cobra) for use of his Parent/Child code and various other bits and pieces.
 *  
 *  This App is free.  If you like and use this app, please be sure to give a shout out on the Hubitat forums to let
 *  people know that it exists!  Thanks.
 *
 *  Remember...I am not a programmer, everything I do takes a lot of time and research!
 *  Donations are never necessary but always appreciated.  Donations to support development efforts are accepted via: 
 *
 *  Paypal at: https://paypal.me/bptworld
 *
 *-------------------------------------------------------------------------------------------------------------------
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 * ------------------------------------------------------------------------------------------------------------------------------
 *
 *  If modifying this project, please keep the above header intact and add your comments/credits below - Thank you! -  @BPTWorld
 *
 *  App and Driver updates can be found at https://github.com/bptworld/Hubitat
 *
 * ------------------------------------------------------------------------------------------------------------------------------
 *
 *  Changes:
 *
 *  
 *  V0.0.1 - 01/14/19 - Initial Beta Release
 *
 */

definition(
    name: "At Home Simulator Child",
    namespace: "BPTWorld",
    author: "Bryan Turcotte",
    description: "Turn lights on and off to simulate the appearance of an occupied home using YOUR normal routine.",
    category: "",
    
parent: "BPTWorld:At Home Simulator",
    
    iconUrl: "",
    iconX2Url: "",
    iconX3Url: "",
    )

preferences {
    page name: "pageConfig"
}

def pageConfig() {
    dynamicPage(name: "", title: "<h2 style='color:#1A77C9;font-weight: bold'>At Home Simulator</h2>", nextPage: null, install: true, uninstall: true, refreshInterval:0) {		display()
		section("Instructions:", hideable: true, hidden: true) {
			paragraph "<b>What does this do?</b>"
			paragraph "This app is designed to give a lived in look based on <b>your</b> daily routine. This is not a random lights generator. Think about your normal daily routine and then program the lights to duplicate how you would normally move about the house. So if you get up at 6:00am but the sun doesn't come up until 8:00am, be sure to create a simulator that lasts at least 2 hours."
			paragraph "<b>Requirements:</b>"
			paragraph "- Rule Machine and a Virtual Switch"
			paragraph "Using the power of Rule Machine, set up a rule to turn the Virtual Switch to control this simulator on. This way you get to use every type of restriction available including offsets, without reinventing the wheel over here."
			paragraph "<b>Notes:</b>"
			paragraph "* Select as many devices from each group as needed.<br>* Child Apps are activated/deactivated by the Control Switch.<br>* When activated, group 1 will run first, then group 2, group 3, group 4 and group 5.<br>* Set how long each group of lights stays on<br>* Each group can have a different pause between devices AND a different pause between groups.<br>* Best to create overlaps in lighting from room to room, using multiple groups"	
		}
		section(getFormat("header-green", "${getImage("Blank")}"+" Control Switch")) {
			input "controlSwitch", "capability.switch", title: "Select the switch to control the Lighting Routine (on/off)", required: true, multiple: false
			input "tRunTime", "number", title: "Total run time. This will stop the app even if it didn't finish the entire simulator (in minutes)", required: true, defaultValue: 360
		} 
		section(getFormat("header-green", "${getImage("Blank")}"+" Lighting Routines")) {}
		section("<b>Group 1</b>", hideable: true, hidden: true) {
			input "g1Switches", "capability.switch", title: "Switches to control", required: true, multiple: true, submitOnChange: true
			if(g1Switches) input "g1TimeToStayOn", "number", title: "How long should lights stay On, from the time the last switch turns on (in minutes)", required: true, defaultValue: 5
			if(g1Switches) input "timeToPause1", "number", title: "Time to pause between devices turning On (in seconds)", required: true, defaultValue: 1
			if(g1Switches) input "timeToPause1a", "number", title: "<b>*</b> Extra Time to pause between Group 1 and 2 (in minutes)", required: true, defaultValue: 0
		}
		section("<b>Group 2</b>", hideable: true, hidden: true) {
			input "g2Switches", "capability.switch", title: "Switches to control", required: false, multiple: true, submitOnChange: true
			if(g2Switches) input "g2TimeToStayOn", "number", title: "How long should lights stay On, from the time the last switch turns on (in minutes)", required: true, defaultValue: 5
			if(g2Switches) input "timeToPause2", "number", title: "Time to pause between devices turning On (in seconds)", required: true, defaultValue: 1
			if(g2Switches) input "timeToPause2a", "number", title: "<b>*</b> Extra Time to pause between Group 2 and 3 (in seconds)", required: true, defaultValue: 0
		}
		
		section("<b>Group 3</b>", hideable: true, hidden: true) {
			input "g3Switches", "capability.switch", title: "Switches to control", required: false, multiple: true, submitOnChange: true
			if(g3Switches) input "g3TimeToStayOn", "number", title: "How long should lights stay On, from the time the last switch turns on (in minutes)", required: true, defaultValue: 5
			if(g3Switches) input "timeToPause3", "number", title: "Time to pause between devices turning On (in seconds)", required: true, defaultValue: 1
			if(g3Switches) input "timeToPause3a", "number", title: "<b>*</b> Extra Time to pause between Group 3 and 4 (in seconds)", required: true, defaultValue: 0
		}
		section("<b>Group 4</b>", hideable: true, hidden: true) {
			input "g4Switches", "capability.switch", title: "Switches to control", required: false, multiple: true, submitOnChange: true
			if(g4Switches) input "g4TimeToStayOn", "number", title: "How long should lights stay On, from the time the last switch turns on (in minutes)", required: true, defaultValue: 5
			if(g4Switches) input "timeToPause4", "number", title: "Time to pause between devices turning On (in seconds)", required: true, defaultValue: 1
			if(g4Switches) input "timeToPause4a", "number", title: "<b>*</b> Extra Time to pause between Group 4 and 5 (in seconds)", required: true, defaultValue: 0
		}
		section("<b>Group 5</b>", hideable: true, hidden: true) {
			input "g5Switches", "capability.switch", title: "Switches to control", required: false, multiple: true, submitOnChange: true
			if(g5Switches) input "g5TimeToStayOn", "number", title: "How long should lights stay On, from the time the last switch turns on (in minutes)", required: true, defaultValue: 5
			if(g5Switches) input "timeToPause5", "number", title: "Time to pause between devices turning On (in seconds)", required: true, defaultValue: 1
		}
		section(getFormat("header-green", "${getImage("Blank")}"+" Random Lights")) {}
		section("<b>Random Lights</b>", hideable: true, hidden: true) {
			paragraph "Some times you just need to break away from the daily routine. Choose a couple of lights here (not included in the above Groups) to randomly turn on and off while the Group routines continue to run."
			input "rSwitches", "capability.switch", title: "Switches to randomly control, only one light in this group will be on at a time", required: false, multiple: true, submitOnChange: true
			if(rSwitches) input "rTimeToStayOn", "number", title: "How long should each light stay On (in minutes)", required: true, defaultValue: 5
			if(rSwitches) input "timeToPauseR", "number", title: "Time to pause between devices turning On (in minutes)", required: true, defaultValue: 10
		}
		section(getFormat("header-green", "${getImage("Blank")}"+" General")) {label title: "Enter a name for this automation", required: false}
		
		section() {
			input(name: "enablerSwitch1", type: "capability.switch", title: "Enable/Disable child app with this switch - If Switch is ON then app is disabled, if Switch is OFF then app is active.", required: false, multiple: false)
		}
        section() {
            input(name: "debugMode", type: "bool", defaultValue: "true", title: "Enable Debug Logging", description: "Enable extra logging for debugging.")
		}
		display2()
	}
}

def getImage(type) {
    def loc = "<img src=https://raw.githubusercontent.com/bptworld/Hubitat/master/resources/images/"
    if(type == "Blank") return "${loc}blank.png height=35 width=5}>"
}

def getFormat(type, myText=""){
	if(type == "header-green") return "<div style='color:#ffffff;font-weight: bold;background-color:#81BC00;border: 1px solid;box-shadow: 2px 3px #A9A9A9'>${myText}</div>"
    if(type == "line") return "\n<hr style='background-color:#1A77C9; height: 1px; border: 0;'></hr>"
	if(type == "title") return "<div style='color:blue;font-weight: bold'>${myText}</div>"
}

def installed() {
    log.debug "Installed with settings: ${settings}"
	initialize()
}

def updated() {	
    LOGDEBUG("Updated with settings: ${settings}")
	unschedule()
    unsubscribe()
	logCheck()
	initialize()
}

def initialize() {
	subscribe(controlSwitch, "switch.on", deviceOnHandler)
	subscribe(controlSwitch, "switch.on", randomSwitchesHandler)
	subscribe(controlSwitch, "switch.off", deviceOffHandler)
	
	int tRT = (tRunTime * 60)			// Minutes
	runIn(tRT, deviceOffHandler)
}

def deviceOnHandler(evt) {
	if(g1Switches) { 
		int delay1 = (timeToPause1 * 1000)			// Seconds
		int delay1a = (timeToPause1a * 60)	* 1000	// Minutes
		int g1TTSO = (g1TimeToStayOn * 60)			// Minutes
   		g1Switches.each { device ->
			LOGDEBUG("In deviceOnHandler 1...turning on ${device}, Time to Stay On: ${g1TimeToStayOn}")
        	device.on()
			runIn(g1TTSO, g1SwitchesOff)
			pauseExecution(delay1)
    	}
		pauseExecution(delay1a)
	}
	
	if(g2Switches) { 
		int delay2 = (timeToPause2 * 1000) 			// Seconds
		int delay2a = (timeToPause2a * 60) * 1000	// Minutes
		int g2TTSO = (g2TimeToStayOn * 60)			// Minutes
   		g2Switches.each { device ->
			LOGDEBUG("In deviceOnHandler 2...turning on ${device}, Time to Stay On: ${g2TimeToStayOn}")
        	device.on()
			runIn(g2TTSO, g2SwitchesOff)
			pauseExecution(delay2)
    	}
		pauseExecution(delay2a)
	}
	
	if(g3Switches) { 
		int delay3 = timeToPause3 * 1000 			// Seconds
		int delay3a = (timeToPause3a * 60) * 1000	// Minutes
		int g3TTSO = (g3TimeToStayOn * 60)			// Minutes
   		g3Switches.each { device ->
			LOGDEBUG("In deviceOnHandler 3...turning on ${device}, Time to Stay On: ${g3TimeToStayOn}")
        	device.on()
			runIn(g3TTSO, g3SwitchesOff)
			pauseExecution(delay3)
    	}
		pauseExecution(delay3a)
	}
	if(g4Switches) { 
		int delay4 = timeToPause4 * 1000 			// Seconds
		int delay4a = (timeToPause4a * 60) * 1000	// Minutes
		int g4TTSO = (g4TimeToStayOn * 60)			// Minutes
   		g4Switches.each { device ->
			LOGDEBUG("In deviceOnHandler 4...turning on ${device}, Time to Stay On: ${g4TimeToStayOn}")
        	device.on()
			runIn(g4TTSO, g4SwitchesOff)
			pauseExecution(delay4)
    	}
		pauseExecution(delay4a)
	}
	if(g5Switches) { 
		int delay5 = timeToPause5 * 1000 			// Seconds
		int delay5a = (timeToPause5a * 60) * 1000	// Minutes
		int g5TTSO = (g5TimeToStayOn * 60)			// Minutes
   		g5Switches.each { device ->
			LOGDEBUG("In deviceOnHandler 5...turning on ${device}, Time to Stay On: ${g5TimeToStayOn}")
        	device.on()
			runIn(g5TTSO, g5SwitchesOff)
			pauseExecution(delay5)
    	}
		pauseExecution(delay5a)
	}
}

def randomSwitchesHandler(evt) { 
	LOGDEBUG("In randomSwitchesHandler...timeToPauseR: ${timeToPauseR}, rTimeToStayOn: ${rTimeToStayOn}")
	int delayR = (timeToPauseR * 60)		 	// Minutes
	int rTTSO = (rTimeToStayOn * 60)			// Minutes
	
	def randomS = rSwitches.size();
	def randomKey1 = Math.abs(new Random().nextInt() % randomS)
	rSwitch = rSwitches[randomKey1]
	
	LOGDEBUG("In randomSwitchesHandler...turning on ${rSwitch}, Time to Stay On: ${rTimeToStayOn} * * * * * *")
    rSwitch.on()
	runIn(rTTSO, rSwitchesOff)
	
    runIn(delayR, randomSwitchesHandler)
}

def g1SwitchesOff() { 
	int delay1 = timeToPause1 * 1000 		// Seconds
   	g1Switches.each { device ->
		LOGDEBUG("In g1SwitchesOff 1...turning off ${device}")
        device.off()
		pauseExecution(delay1)
    }
}

def g2SwitchesOff() { 
	int delay2 = timeToPause2 * 1000 		// Seconds
   	g2Switches.each { device ->
		LOGDEBUG("In g2witchesOff 2...turning off ${device}")
        device.off()
		pauseExecution(delay2)
    }
}

def g3SwitchesOff() { 
	int delay3 = timeToPause3 * 1000 		// Seconds
   	g3Switches.each { device ->
		LOGDEBUG("In g3SwitchesOff 3...turning off ${device}")
        device.off()
		pauseExecution(delay3)
    }
}

def g4SwitchesOff() { 
	int delay4 = timeToPause4 * 1000 		// Seconds
   	g1Switches.each { device ->
		LOGDEBUG("In g4SwitchesOff 4...turning off ${device}")
        device.off()
		pauseExecution(delay4)
    }
}

def g5SwitchesOff() { 
	int delay5 = timeToPause5 * 1000 		// Seconds
   	g5Switches.each { device ->
		LOGDEBUG("In g5SwitchesOff 5...turning off ${device}")
        device.off()
		pauseExecution(delay5)
    }
}

def rSwitchesOff() { 
	int delayR = timeToPauseR * 1000 		// Seconds
   	rSwitches.each { device ->
		LOGDEBUG("In rSwitchesOff R...turning off ${device}")
        device.off()
		pauseExecution(delayR)
    }
}

def deviceOffHandler(evt) {
	if(g1Switches) { 
   		g1Switches.each { device ->
			LOGDEBUG("In deviceOffHandler 1...turning all lights off ${device}")
        	device.off()
    	}
	}
	if(g2Switches) { 
   		g2Switches.each { device ->
			LOGDEBUG("In deviceOffHandler 2...turning all lights off ${device}")
        	device.off()
    	}
	}
	if(g3Switches) { 
   		g3Switches.each { device ->
			LOGDEBUG("In deviceOffHandler 3...turning all lights off ${device}")
        	device.off()
    	}
	}
	if(g4Switches) { 
   		g4Switches.each { device ->
			LOGDEBUG("In deviceOffHandler 4...turning all lights off ${device}")
        	device.off()
    	}
	}
	if(g5Switches) { 
   		g5Switches.each { device ->
			LOGDEBUG("In deviceOffHandler 5...turning all lights off ${device}")
        	device.off()
    	}
	}
	if(rSwitches) { 
   		rSwitches.each { device ->
			LOGDEBUG("In deviceOffHandler R...turning all lights off ${device}")
        	device.off()
    	}
	}
	unschedule()
	controlSwitch.off()
	LOGDEBUG("In deviceOffHandler...ALL FINISHED")
}

// ***** Normal Stuff *****

def pauseOrNot(){
	LOGDEBUG("In pauseOrNot...")
    state.pauseNow = pause1
        if(state.pauseNow == true){
            state.pauseApp = true
            if(app.label){
            if(app.label.contains('red')){
                log.warn "Paused"}
            else{app.updateLabel(app.label + ("<font color = 'red'> (Paused) </font>" ))
              LOGDEBUG("App Paused - state.pauseApp = $state.pauseApp ")   
            }
            }
        }
     if(state.pauseNow == false){
         state.pauseApp = false
         if(app.label){
     if(app.label.contains('red')){ app.updateLabel(app.label.minus("<font color = 'red'> (Paused) </font>" ))
     	LOGDEBUG("App Released - state.pauseApp = $state.pauseApp ")                          
        }
     }
  }    
}

def logCheck(){
	state.checkLog = debugMode
	if(state.checkLog == true){
		log.info "${app.label} - All Logging Enabled"
	}
	else if(state.checkLog == false){
		log.info "${app.label} - Further Logging Disabled"
	}
}

def LOGDEBUG(txt){
    try {
		if (settings.debugMode) { log.debug("${app.label} - ${txt}") }
    } catch(ex) {
    	log.error("${app.label} - LOGDEBUG unable to output requested data!")
    }
}

def display() {
	section() {
		paragraph getFormat("line")
		input "pause1", "bool", title: "Pause This App", required: true, submitOnChange: true, defaultValue: false
	}
}

def display2() {
	section() {
		paragraph getFormat("line")
		paragraph "<div style='color:#1A77C9;text-align:center'>At Home Simulator - App Version: Beta 0.0.1 - @BPTWorld<br><a href='https://github.com/bptworld/Hubitat' target='_blank'>Find more apps on my Github, just click here!</a></div>"
	}
}