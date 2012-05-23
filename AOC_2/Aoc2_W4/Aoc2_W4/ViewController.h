//
//  ViewController.h
//  Aoc2_W4
//
//  Created by Luis Puente on 5/22/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AddEventController.h"

@interface ViewController : UIViewController <AddEventsDelegate>

//UI Elements
{
    IBOutlet UILabel *dateTitle;
    IBOutlet UILabel *pleaseAdd;
    IBOutlet UITextView *eventList;
    IBOutlet UIButton *addEvent;    //will use swipe control to add event//
    
    //Must use nsmutableString due to changing/editable info//
    
    NSMutableString *savedUserInfo;
}

//Action for Add Event button//

-(IBAction)onAddEvent:(id)sender;


@end
