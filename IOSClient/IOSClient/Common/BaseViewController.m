//
//  BaseViewController.m
//  IOSClient
//
//  Created by 欧阳锋 on 18/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import "BaseViewController.h"

@interface BaseViewController ()

@end

@implementation BaseViewController

- (void)promptError: (NSString *)error {
    [self promptError: error handler: nil];
}

- (void)promptError:(NSString *)error handler:(nullable void (^)(UIAlertAction *))handler {
    UIAlertController *alertController = [UIAlertController alertControllerWithTitle: nil message: error preferredStyle: UIAlertControllerStyleAlert];
    [alertController addAction: [UIAlertAction actionWithTitle: @"确定" style: UIAlertActionStyleDefault handler: handler]];
    [self presentViewController: alertController animated: YES completion: nil];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
