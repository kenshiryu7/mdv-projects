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
//how screen should look when first opening. White BG and switch off.
    
    display.text = @"0";
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


////////////////////////////////   All Action calls here   //////////////////////////////////////////////////

//switch on/off action

-(IBAction)onSwitched:(id)sender
{
    //using video example to see if i can put the pieces together//
    UISwitch *thisSwitch = (UISwitch*)sender;
    if(thisSwitch != nil)
    {
        int tag = thisSwitch.tag;
        NSString *temp = [NSString stringWithFormat:@"testing %d", tag];
        NSLog(@"%@",temp);
//if statement to turn bg back to white and display to 0 when clicked//        
        if(tag == 0)
        {
            self.view.backgroundColor = [UIColor whiteColor];
            display.text = @"0";
        }

    }
}

//action for digits pressed and displaying in textfield//

-(IBAction)digitPressed:(id)sender
{
    if(onOffSwitch.on != false)
    {    
    currentNumber = currentNumber *10 + (float)[sender tag];
    display.text = [NSString stringWithFormat:@"%.0f", currentNumber];
    }
}

//operation equals and add//

-(IBAction)operationPressed:(id)sender
{
    if(onOffSwitch.on != false)
    {    

        if(currentOperation == 0) 
        {
            result = currentNumber;
        }
        else
        {
            switch (currentOperation)
            {
                case 1:
                    result = result + currentNumber;
                    break;
                case 2:
                    currentOperation = 0;
                    break;
            }
        }
        currentNumber = 0;
        display.text = [NSString stringWithFormat:@"%.0f", result];
        if([sender tag] == 0)
            result = 0;
        currentOperation = [sender tag];
    }
    
}

//action to clear text display and show 0//

-(IBAction)clearDisplay:(id)sender
{
    if(onOffSwitch.on != false)
    {    
        currentNumber = 0;
        display.text =@"0";
        currentOperation = 0;
    }
}

//Action for secondView display.

-(IBAction)onSecondView:(id)sender
{
    if(onOffSwitch.on != false)
    {
        SecondViewController *secondView = [[SecondViewController alloc] initWithNibName:@"SecondView" bundle:nil];
        if(secondView != nil)
        {
            [self presentModalViewController:secondView animated:TRUE];
        }
    }    
}

//Action for color segment button//

-(IBAction)onColorChange:(id)sender
{
    if(onOffSwitch.on != false)
    {    
        UISegmentedControl *segControl = (UISegmentedControl*)sender;
        if(segControl != nil)
        {
            int selectedIndex = segControl.selectedSegmentIndex;
        
            /* switch (selectedIndex)
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
             }*/
        
            //This wasnt working. Break point not working either. Is code wrong?//        
        
            if(selectedIndex == 0)
            {
                self.view.backgroundColor = [UIColor whiteColor];
            }
            else if( selectedIndex == 1)
            {
                //attempt at changing info dark to light when bg turns blue. Not working//
                //secondViewInfo = [UIButton buttonWithType:UIButtonTypeInfoLight];
                self.view.backgroundColor = [UIColor blueColor];
                
            }
            else if( selectedIndex == 2)
            {
                self.view.backgroundColor = [UIColor greenColor];
            }
        }
    
    }
}




@end
