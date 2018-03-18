//
//  BaseViewController.h
//  IOSClient
//
//  Created by 欧阳锋 on 18/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface BaseViewController : UIViewController

- (void)promptError: (NSString *)error;

- (void)promptError: (NSString *)error handler: (nullable void (^)(UIAlertAction *action)) handler;

@end
