//
//  ViewController.m
//  Aoc2_W4
//
//  Created by Luis Puente on 5/22/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "AddEventController.h"


@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
//Following video example//    
    
    rightSwipe = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(onSwipe:)];
    rightSwipe.direction = UISwipeGestureRecognizerDirectionRight;
    [swipeRightEvent addGestureRecognizer:rightSwipe];
    
    //only Right gesture needed. Following video to show that both can be done on same action.//
    
    /*leftSwipe = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(onSwipe:)];
    leftSwipe.direction = UISwipeGestureRecognizerDirectionLeft;
    [swipeRightEvent addGestureRecognizer:leftSwipe];
    */
    
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Action to lead to second view....Replaced with Swipe action to do same thing.

/*
-(IBAction)onAddEvent:(id)sender
{
    AddEventController *showAddEvent = [[AddEventController alloc] initWithNibName:@"AddEvent" bundle:nil];
    if(showAddEvent != nil)
    {
        showAddEvent.delegate = self;
        [self presentModalViewController:showAddEvent animated:TRUE];
    }
}
*/


//Action for swipe Right //

-(void)onSwipe:(UISwipeGestureRecognizer*)recognizer
{
    if(recognizer.direction == UISwipeGestureRecognizerDirectionRight)
    {
        AddEventController *showAddEvent = [[AddEventController alloc] initWithNibName:@"AddEvent" bundle:nil];
        if(showAddEvent != nil)
        {
            showAddEvent.delegate = self;
            [self presentModalViewController:showAddEvent animated:TRUE];
        } 
    }
}

//Action example from video. Lets see if this works. Should grab data from Save button action in second view

-(void)didClose:(NSString *)eventSavedString
{
    if(eventList.text == savedUserInfo)
    {
        
        savedUserInfo =[NSMutableString stringWithString:eventList.text];
        [savedUserInfo appendString:eventSavedString];
        eventList.text = savedUserInfo;
    }
    else
    {
        pleaseAdd.text = @"";
        savedUserInfo =[NSMutableString stringWithString:eventList.text];
        [savedUserInfo appendString:eventSavedString];
        eventList.text = savedUserInfo;
    }
}

-(IBAction)onSaveButton:(id)sender
{
    
}

-(IBAction)onClear:(id)sender
{
    eventList.text =@"";
}

@end
