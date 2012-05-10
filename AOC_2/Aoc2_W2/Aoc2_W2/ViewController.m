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

- (void)viewDidLoad
{

    
    onOffSwitch.on = false;
    
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

//Action for color segment button//

-(IBAction)onColorChange:(id)sender
{
    UISegmentedControl *segControl = (UISegmentedControl*)sender;
    if(segControl != nil)
    {
        int selectedIndex = segControl.selectedSegmentIndex;
        if(selectedIndex == 0)
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
        }
    }
}


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
