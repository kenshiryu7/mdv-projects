//
//  ViewController.m
//  Aoc2_W2
//
//  Created by Luis Puente on 5/6/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "SecondViewController.h"

@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

-(IBAction)onColorChange:(id)sender
{
    UISegmentedControl *segControl = (UISegmentedControl*)sender;
    if(segControl != nil)
    {
        int selectedIndex = segControl.selectedSegmentIndex;
        
        switch (selectedIndex)
        {
                //trying case method to see if will work//                
            case 0:
                self.view.backgroundColor = [UIColor whiteColor];
                break;
                
            case 1:
                self.view.backgroundColor = [UIColor blueColor];
                break;
                
            case 2:
                self.view.backgroundColor = [UIColor greenColor];
                break;
                
            default:
                self.view.backgroundColor = [UIColor whiteColor];
                break;
        }
        
        //This wasnt working. Break point not working either. Is code wrong?//        
        
        /* if(selectedIndex == 0)
         {
         self.view.backgroundColor = [UIColor whiteColor];
         }
         else if( selectedIndex == 1)
         {
         self.view.backgroundColor = [UIColor blueColor];
         }
         else if( selectedIndex == 2)
         {
         self.view.backgroundColor = [UIColor greenColor];
         }*/
    }
}

- (void)viewDidLoad
{
//how screen should look when first opening. White BG and switch off.
    
    
    onOffSwitch.on = false;
    self.view.backgroundColor = [UIColor whiteColor];
    
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
    
    onOffSwitch.on = false;
    //follow along from video//
    
     //int selectedIndex = segmentControl.selectedSegmentIndex;
   
    self.view.backgroundColor = [UIColor whiteColor];
    
    
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

//switch on/off action

-(IBAction)onSwitched:(id)sender
{
    
}

//Action for color segment button//



//Action for secondView display.

-(IBAction)onSecondView:(id)sender
{
    SecondViewController *secondView = [[SecondViewController alloc] initWithNibName:@"SecondView" bundle:nil];
    if(secondView != nil)
    {
        [self presentModalViewController:secondView animated:TRUE];
    }
}



@end
