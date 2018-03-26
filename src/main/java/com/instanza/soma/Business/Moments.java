package com.instanza.soma.Business;

import com.instanza.soma.Service.Social.MomentsPage;
import com.instanza.soma.Service.Tools.GalleryPage;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.testng.Reporter;

/**
 * Created by trista on 2017/3/10.
 */
public class Moments {
    public AppOperation appOperation;
    private static Moments momentsObj;
    private String ActivateType;

    public static Moments getInstance() {
        if (momentsObj == null) {
            synchronized (Moments.class) {
                if (momentsObj == null) {
                    momentsObj = new Moments();
                }
            }
        }
        return momentsObj;
    }

    public Moments() {
        appOperation = AppOperationImp.getInstance();
    }

    public void SentMomentFromAllEntry(AppiumDriver driver) {
        MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.Moments, GalleryPage.PhotoEntry.ChoosePhoto);
        MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.Moments, GalleryPage.PhotoEntry.TakePhoto);
        MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.MyMoments, GalleryPage.PhotoEntry.ChoosePhoto);
        MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.MyMoments, GalleryPage.PhotoEntry.TakePhoto);

    }

    public void SentMomentAllKindOfPhotoNumber(AppiumDriver driver) {
        MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.Moments, GalleryPage.PhotoEntry.ChoosePhoto);
        MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.Moments, GalleryPage.PhotoEntry.ChoosePhoto);
        //    MomentsPage.getInstance().SentMoment(driver, MomentsPage.MomentEntry.Moments, MomentsPage.PhotoEntry.ChoosePhoto, 10);
    }

    public void SentMomentAttachAll(AppiumDriver driver) {
        MomentsPage.getInstance().SentMomentEntry(driver, MomentsPage.MomentEntry.Moments);
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.ChoosePhoto, GalleryPage.PhotoAction.select, 1);
        MomentsPage.getInstance().AttachText(driver);
        MomentsPage.getInstance().AttachLocation(driver);
        MomentsPage.getInstance().AttachShare(driver);
        MomentsPage.getInstance().AttachPlus(driver);
        MomentsPage.getInstance().SentMomentTail(driver);
        MomentsPage.getInstance(). SentMoment4(driver);
        MomentsPage.getInstance().SentMoment9(driver, 10);
        MomentsPage.getInstance().SentMoment9(driver, 9);

    }

    public void MyMomentComments(AppiumDriver driver) {
        MomentsPage.getInstance().MyMomentComments(driver);

    }

    /*public void Momentcomments(AppiumDriver driver) {
        MomentsPage.getInstance().Momentcomments(driver);
    }
    */
    public void MomentcoverUpdateByselectPhoto(AppiumDriver driver) {
        MomentsPage.getInstance().MomentcoverUpdateByselectPhoto(driver);
    }

    public void MomentcoverUpdateBytakePhoto(AppiumDriver driver) {
        MomentsPage.getInstance().MomentcoverUpdateBytakePhoto(driver);
    }
}