//
//  ViewController.h
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ShapeClass.h"
#import "TriangleClass.h"
#import "SquareClass.h"
#import "RectangleClass.h"
#import "ShapeFactory.h"

@interface ViewController : UIViewController
{
    UILabel *triangleShape;
    UILabel *squareShape;
    UILabel *rectangleShape;
    
    ShapeClass *shapeClass;
    ShapeFactory *shapeFactory;
}

@end
