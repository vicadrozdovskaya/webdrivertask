package com.epam.mentoring.tests;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.pages.google.cloud.MainGoogleCloudPage;
import com.epam.mentoring.pages.google.cloud.ProductCalculatorsGoogleCloudPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HurtMePlentyTest extends BaseTest {
    private static final int NUMBER_OF_INSTANCES = 4;
    private static final String OPERATION_SYSTEM = "Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String VM_CLASS = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String NUMBER_OF_GPUS = "1";
    private static final String GPUS_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    private static final String COMMITED_USAGE = "1 Year";

    ProductCalculatorsGoogleCloudPage productCalculatorsGoogleCloudPage;

    @BeforeClass
    public void fillAllFields() {
        MainGoogleCloudPage mainGoogleCloudPage = new MainGoogleCloudPage().openPage()
                .clickTabPricing().clickTabPricingCalculator();
        productCalculatorsGoogleCloudPage = new ProductCalculatorsGoogleCloudPage()
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
        Assert.assertEquals(productCalculatorsGoogleCloudPage.getFieldFromEstimate("VM class"), "VM class: " + VM_CLASS.toLowerCase(), "VM Class: not equal");
    }

    @Test(description = "check Instance type in estimate section")
    public void checkInstanceTypeTest() {
        Assert.assertEquals(productCalculatorsGoogleCloudPage.getFieldFromEstimate("Instance type"), "Instance type: " + INSTANCE_TYPE.split(" ")[0], "Instance type:  not equal");
    }

    @Test(description = "check Region  in estimate section")
    public void checkRegionTest() {
        Assert.assertEquals(productCalculatorsGoogleCloudPage.getFieldFromEstimate("Region"), "Region: " + DATACENTER_LOCATION.split(" ")[0], "Region:  not equal");
    }

    @Test(description = "check local SSD in estimate section")
    public void CheckLocalSSDTest() {
        Assert.assertEquals(productCalculatorsGoogleCloudPage.getFieldFromEstimate("local SSD"), "Total available local SSD space " + LOCAL_SSD, "local SSD: no equals");
    }

    @Test(description = "check Commitment term in estimate section")
    public void CheckCommitmentTermTest() {
        Assert.assertEquals(productCalculatorsGoogleCloudPage.getFieldFromEstimate("Commitment term:"), "Commitment term: " + COMMITED_USAGE, "Commitment term: no equals");
    }
}
