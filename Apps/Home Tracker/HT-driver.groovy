/**
 *  ****************  Home Tracker Driver  ****************
 *
 *  Design Usage:
 *  This driver stores Global Variables to be used with Home Tracker.
 *
 *  Copyright 2019 Bryan Turcotte (@bptworld)
 *  
 *  This App is free.  If you like and use this app, please be sure to mention it on the Hubitat forums!  Thanks.
 *
 *  Remember...I am not a programmer, everything I do takes a lot of time and research (then MORE research)!
 *  Donations are never necessary but always appreciated.  Donations to support development efforts are accepted via: 
 *
 *  Paypal at: https://paypal.me/bptworld
 * 
 *  Unless noted in the code, ALL code contained within this app is mine. You are free to change, ripout, copy, modify or
 *  otherwise use the code in anyway you want. This is a hobby, I'm more than happy to share what I have learned and help
 *  the community grow. Have FUN with it!
 * 
 * ------------------------------------------------------------------------------------------------------------------------------
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
 *  V1.0.2 - 12/12/19 - Adjustments to match app
 *  V1.0.1 - 12/10/19 - Adjustments for Locks
 *  V1.0.0 - 09/10/19 - Initial release
 */

def setVersion(){
    appName = "HomeTrackerDriver"
	version = "v1.0.2" 
    dwInfo = "${appName}:${version}"
    sendEvent(name: "dwDriverInfo", value: dwInfo, displayed: true)
}

def updateVersion() {
    log.info "In updateVersion"
    setVersion()
}

metadata {
	definition (name: "Home Tracker Driver", namespace: "BPTWorld", author: "Bryan Turcotte", importUrl: "https://raw.githubusercontent.com/bptworld/Hubitat/master/Apps/Home%20Tracker/HT-driver.groovy") {
   		capability "Actuator"
		
		command "sendDataMap01", ["string"]
		command "sendDataMap02", ["string"]
		command "sendDataMap03", ["string"]
		command "sendDataMap04", ["string"]
		command "sendDataMap05", ["string"]
        command "sendDataMap06", ["string"]
        command "sendDataMap07", ["string"]
        command "sendDataMap08", ["string"]
        command "sendDataMap09", ["string"]
        command "sendDataMap10", ["string"]
        command "sendDataMap11", ["string"]
        command "sendDataMap12", ["string"]
        command "sendDataMap13", ["string"]
        command "sendDataMap14", ["string"]
        command "sendDataMap15", ["string"]
        command "sendDataMap16", ["string"]
        command "sendDataMap17", ["string"]
        command "sendDataMap18", ["string"]
        command "sendDataMap19", ["string"]
        command "sendDataMap20", ["string"]
        command "sendDataMap21", ["string"]
        command "sendDataMap22", ["string"]
        command "sendDataMap23", ["string"]
        command "sendDataMap24", ["string"]
		
		attribute "globalBH01", "string"
		attribute "globalBH02", "string"
		attribute "globalBH03", "string"
		attribute "globalBH04", "string"
		attribute "globalBH05", "string"
        attribute "globalBH06", "string"
        attribute "globalBH07", "string"
        attribute "globalBH08", "string"
        attribute "globalBH09", "string"
        attribute "globalBH10", "string"
        attribute "globalBH11", "string"
        attribute "globalBH12", "string"
        attribute "globalBH13", "string"
        attribute "globalBH14", "string"
        attribute "globalBH15", "string"
        attribute "globalBH16", "string"
        attribute "globalBH17", "string"
        attribute "globalBH18", "string"
        attribute "globalBH19", "string"
        attribute "globalBH20", "string"
        attribute "globalBH21", "string"
        attribute "globalBH22", "string"
        attribute "globalBH23", "string"
        attribute "globalBH24", "string"
        
        attribute "dwDriverInfo", "string"
        command "updateVersion"	
	}
	preferences() {    	
        section(){
            input("logEnable", "bool", title: "Enable logging", required: false, defaultValue: false)
        }
    }
}

def sendDataMap01(dataMap1) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap1 - Received new data!"
	def dMap1 = "${dataMap1}"
	sendEvent(name: "globalBH01", value: dMap1, displayed: true)
}
def sendDataMap02(dataMap2) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap2 - Received new data!"
	def dMap2 = "${dataMap2}"
	sendEvent(name: "globalBH02", value: dMap2, displayed: true)
}
def sendDataMap03(dataMap3) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap3 - Received new data!"
	def dMap3 = "${dataMap3}"
	sendEvent(name: "globalBH03", value: dMap3, displayed: true)
}
def sendDataMap04(dataMap4) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap4 - Received new data!"
	def dMap4 = "${dataMap4}"
	sendEvent(name: "globalBH04", value: dMap4, displayed: true)
}
def sendDataMap05(dataMap5) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap5 - Received new data!"
	def dMap5 = "${dataMap5}"
	sendEvent(name: "globalBH05", value: dMap5, displayed: true)
}

def sendDataMap06(dataMap6) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap6 - Received new data!"
	def dMap6 = "${dataMap6}"
	sendEvent(name: "globalBH06", value: dMap6, displayed: true)
}

def sendDataMap07(dataMap7) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap7 - Received new data!"
	def dMap7 = "${dataMap7}"
	sendEvent(name: "globalBH07", value: dMap7, displayed: true)
}

def sendDataMap08(dataMap8) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap8 - Received new data!"
	def dMap8 = "${dataMap8}"
	sendEvent(name: "globalBH08", value: dMap8, displayed: true)
}

def sendDataMap09(dataMap9) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap9 - Received new data!"
	def dMap9 = "${dataMap9}"
	sendEvent(name: "globalBH09", value: dMap9, displayed: true)
}

def sendDataMap10(dataMap10) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap10 - Received new data!"
	def dMap10 = "${dataMap10}"
	sendEvent(name: "globalBH10", value: dMap10, displayed: true)
}

def sendDataMap11(dataMap11) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap11 - Received new data!"
	def dMap11 = "${dataMap11}"
	sendEvent(name: "globalBH11", value: dMap11, displayed: true)
}

def sendDataMap12(dataMap12) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap12 - Received new data!"
	def dMap12 = "${dataMap12}"
	sendEvent(name: "globalBH12", value: dMap12, displayed: true)
}

def sendDataMap13(dataMap13) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap13 - Received new data!"
	def dMap13 = "${dataMap13}"
	sendEvent(name: "globalBH13", value: dMap13, displayed: true)
}

def sendDataMap14(dataMap14) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap14 - Received new data!"
	def dMap14 = "${dataMap14}"
	sendEvent(name: "globalBH14", value: dMap14, displayed: true)
}

def sendDataMap15(dataMap15) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap15 - Received new data!"
	def dMap15 = "${dataMap15}"
	sendEvent(name: "globalBH15", value: dMap15, displayed: true)
}

def sendDataMap16(dataMap16) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap16 - Received new data!"
	def dMap16 = "${dataMap16}"
	sendEvent(name: "globalBH16", value: dMap16, displayed: true)
}
def sendDataMap17(dataMap17) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap17 - Received new data!"
	def dMap17 = "${dataMap17}"
	sendEvent(name: "globalBH17", value: dMap17, displayed: true)
}
def sendDataMap18(dataMap18) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap18 - Received new data!"
	def dMap18 = "${dataMap18}"
	sendEvent(name: "globalBH18", value: dMap18, displayed: true)
}
def sendDataMap19(dataMap19) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap19 - Received new data!"
	def dMap19 = "${dataMap19}"
	sendEvent(name: "globalBH19", value: dMap19, displayed: true)
}
def sendDataMap20(dataMap20) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap20 - Received new data!"
	def dMap20 = "${dataMap20}"
	sendEvent(name: "globalBH20", value: dMap20, displayed: true)
}
def sendDataMap21(dataMap21) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap21 - Received new data!"
	def dMap21 = "${dataMap21}"
	sendEvent(name: "globalBH21", value: dMap21, displayed: true)
}
def sendDataMap22(dataMap22) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap22 - Received new data!"
	def dMap22 = "${dataMap22}"
	sendEvent(name: "globalBH22", value: dMap22, displayed: true)
}
def sendDataMap23(dataMap23) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap23 - Received new data!"
	def dMap23 = "${dataMap23}"
	sendEvent(name: "globalBH23", value: dMap23, displayed: true)
}
def sendDataMap24(dataMap24) {
    if(logEnable) log.debug "In Home Tracker Driver - sendDataMap24 - Received new data!"
	def dMap24 = "${dataMap24}"
	sendEvent(name: "globalBH24", value: dMap24, displayed: true)
}
