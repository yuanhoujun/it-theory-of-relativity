//
//  User.h
//  IOSClient
//
//  Created by 欧阳锋 on 18/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <JSONModel.h>

@interface User : JSONModel

@property (nonatomic, assign) NSInteger id;
@property (nonatomic, copy) NSString *name;

@end
