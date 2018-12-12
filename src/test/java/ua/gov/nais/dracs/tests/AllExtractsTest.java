package ua.gov.nais.dracs.tests;

import org.testng.annotations.Test;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;

import java.io.UnsupportedEncodingException;

public class AllExtractsTest extends MainTest {

    private final String CHILD_ACT_RECORD = "3";
    private final String CHANGE_NAME_ACT_RECORD = "4";
    private final String DEATH_ACT_RECORD = "5";
    private final String DIVORCE_ACT_RECORD = "6";
    private final String MARRIAGE_ACT_RECORD = "7";

    private final String EXTRACT_TYPE_DEATH = "18";
    private final String EXTRACT_TYPE_CHILD = "12";
    private final String EXTRACT_TYPE_SUBJ = "21";
    private final String EXTRACT_TYPE_MARRIAGE = "19";
    private final String EXTRACT_TYPE_DIVORCE = "20";

    private final String ROLE_CHILD = "1";
    private final String ROLE_SUBJ_AR = "9";
    private final String ROLE_DEAD = "5";
    private final String ROLE_HUSBAND = "10";
    private final String ROLE_FEANCE = "10";

    ExtractPage extractPage;
    ExtendSearch search;
    SearchByPersonRibbon searchByPersonRibbon;
    ExtractPrint extractPrint;
    /*@Test
    public void birth(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(CHILD_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE_CHILD);
        try {
            extractPage.typeReason(new String("випадково вийшло".getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        searchByPersonRibbon.enterPersonInformation("Ячрюкцезґтузо ", "Робот", "Шжшдйевкжлью");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();

    }
    @Test
    public void death(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(DEATH_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE_DEATH);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_DEAD);
        searchByPersonRibbon.enterPersonInformation("Ячсакяєйрркло", "РоботЯчсакяєйрркло", "Смьбкжчтнукк");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();

    }
    @Test
    public void marriage(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(MARRIAGE_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE_MARRIAGE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_FEANCE);
        searchByPersonRibbon.enterPersonInformation("Яїдгмтшйжщєтз", "РоботЯїдгмтшйжщєтз", "Шршзфжоідачх");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();

    }
    @Test
    public void divorce(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(DIVORCE_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE_DIVORCE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_HUSBAND);
        searchByPersonRibbon.enterPersonInformation("Яидлчсвуґеуоі", "РоботЯидлчсвуґеуоі", "Оокщсьїяуптг");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();

    }
    @Test
    public void name(){
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(CHANGE_NAME_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE_SUBJ);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_SUBJ_AR);
        searchByPersonRibbon.enterPersonInformation("Ямфжрбьувохия", "Робот", "Вхкщїизебфєв");
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPage.generateExtract();
        extractPrint = new ExtractPrint(driver);
        extractPrint.printExtract();

    }*/

}
