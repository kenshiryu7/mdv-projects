//
//  ViewController.h
//  Aoc2_W2
//
//  Created by Luis Puente on 5/6/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
{

//UILabel for background color text//
    
    IBOutlet UILabel *bgColorLabel;  //May have label change with color change//
    
//Text field for display and on and off switch//
    
    IBOutlet UITextField *display;
    IBOutlet UISwitch *onOffSwitch;
    
//variables for calculator//
    
    float result;
    int currentOperation;
    float currentNumber;
    
//segment buttons for 3 colors
    
    IBOutlet UISegmentedControl *segmentControl;
    
//Second view info button//
    
    IBOutlet UIButton * secondViewInfo;
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//switch on/off action

-(IBAction)onSwitched:(id)sender;

//second view button

-(IBAction)onSecondView:(id)sender;

//segment controls//

-(IBAction)onColorChange:(id)sender;

//actions for digits, equals, plus//

-(IBAction)digitPressed:(id)sender;
-(IBAction)operationPressed:(id)sender;
-(IBAction)cancelInput:(id)sender;
-(IBAction)clearDisplay:(id)sender;

@end
