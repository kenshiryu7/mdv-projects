//
//  ShapeFactory.h
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "TriangleClass.h"
#import "SquareClass.h"
#import "RectangleClass.h"

@interface ShapeFactory : NSObject
{
    int index;
}

+(id)CreateShape:(NSInteger)shapeType;

@end
