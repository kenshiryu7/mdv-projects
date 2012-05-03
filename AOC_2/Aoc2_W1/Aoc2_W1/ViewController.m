//
//  ViewController.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "ShapeClass.h"
#import "TriangleClass.h"
#import "SquareClass.h"
#import "RectangleClass.h"
#import "ShapeFactory.h"

@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
     ShapeFactory *shapeFactory = [[ShapeFactory alloc] init];
    if(shapeFactory != nil)
    {
        TriangleClass *triangle =  (TriangleClass*)[shapeFactory CreateShape:1];
        [triangle GetArea];
        triangleShape = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 40.0f, 300.0f, 20.0f)];
        if(triangleShape != nil)
        {
            triangleShape.backgroundColor = [UIColor clearColor];
            triangleShape.text = [NSString stringWithFormat:@"Shape %@ Area: %d",[triangle GetName],[triangle GetArea]];
        }
        [self.view addSubview:triangleShape];
    }
    {
        SquareClass *square =  (SquareClass*)[shapeFactory CreateShape:0];
        [square GetArea];
        squareShape = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 90.0f, 300.0f, 20.0f)];
        if(squareShape != nil)
        {
            squareShape.backgroundColor = [UIColor clearColor];
            squareShape.text = [NSString stringWithFormat:@"Shape %@ Area: %d",[square GetName],[square GetArea]];
        }
        [self.view addSubview:squareShape];
    }
    RectangleClass *rectangle = (RectangleClass*)[shapeFactory CreateShape:2];
    [rectangle GetArea];
    rectangleShape = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 140.0f, 300.0f, 20.0f)];
    if(rectangleShape != nil)
    {
        rectangleShape.backgroundColor = [UIColor clearColor];
        rectangleShape.text = [NSString stringWithFormat:@"Shape %@ Area: %d",[rectangle GetName],[rectangle GetArea]];
    }
    [self.view addSubview:rectangleShape];


    
    
/*UILabels to display string : area value ---added at beginning of project
    
    shapeTriangle = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 40.0f, 300.0f, 20.0f)];
    if(shapeTriangle != nil)
    {
        shapeTriangle.text =@"Shape triangle Area:";
        shapeTriangle.backgroundColor = [UIColor clearColor];
        [self.view addSubview:shapeTriangle];
    }
    
    shapeSquare = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 90.0f, 300.0f, 20.0f)];
    if(shapeSquare != nil)
    {
        shapeSquare.text =@"Shape square Area:";
        shapeSquare.backgroundColor = [UIColor clearColor];
        [self.view addSubview:shapeSquare];
    }

    shapeRect = [[UILabel alloc] initWithFrame:CGRectMake(10.0f, 140.0f, 300.0f, 20.0f)];
    if(shapeRect != nil)
    {
        shapeRect.text =@"Shape rectangle Area:";
        shapeRect.backgroundColor = [UIColor clearColor];
        [self.view addSubview:shapeRect];
    }
*/
    
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

@end
