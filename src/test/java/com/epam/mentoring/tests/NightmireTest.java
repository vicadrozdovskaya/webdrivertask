package com.epam.mentoring.tests;

import com.epam.mentoring.pages.google.cloud.MainGoogleCloudPage;
import com.epam.mentoring.pages.google.cloud.ProductCalculatorsGoogleCloudPageObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NightmireTest extends BaseTest {
    private static final int NUMBER_OF_INSTANCES = 4;
    private static final String OPERATION_SYSTEM = "Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String VM_CLASS = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String NUMBER_OF_GPUS = "1";
    private static final String GPUS_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    private static final String COMMITED_USAGE = "1 Year";

    ProductCalculatorsGoogleCloudPageObject productCalculatorsGoogleCloudPageObject;

    @BeforeClass
    public void fillAllFields() {
        MainGoogleCloudPage mainGoogleCloudPage = new MainGoogleCloudPage().openPage().clickTabPricing().clickTabPricingCalculator();
        productCalculatorsGoogleCloudPageObject = new ProductCalculatorsGoogleCloudPageObject()
                .enterNumberOfInstances(NUMBER_OF_INSTANCES)
                .clickOperationSystem().chooseItemInDropDownMenu(OPERATION_SYSTEM)
                .clickMachineClass().chooseItemInDropDownMenu(VM_CLASS)
                .clickMachineType().chooseMachineTypeInDropDownMenu(INSTANCE_TYPE)
                .clickAddGPUs()
                .clickNumberOfGPUs().chooseItemInDropDownMenu(NUMBER_OF_GPUS)
                .clickGPUType().chooseItemInDropDownMenu(GPUS_TYPE)
                .clickLocalSSD().chooseItemInDropDownMenu(LOCAL_SSD)
                .clickDatacenterLocation().chooseItemInDropDownMenu(DATACENTER_LOCATION)
                .clickCommitedUsage().chooseItemInDropDownMenu(COMMITED_USAGE)
                .clickAddToEstimateBtn();
    }

    @Test(description = "check VM Class in estimate section")
    public void checkVMClassTest() {
        Assert.assertEquals(productCalculatorsGoogleCloudPageObject.getFieldFromEstimate("VM class"), "VM class: " + VM_CLASS.toLowerCase(), "VM Class: not equal");
    }
}
