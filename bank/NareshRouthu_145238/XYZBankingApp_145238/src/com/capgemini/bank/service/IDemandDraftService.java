package com.capgemini.bank.service;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.exception.DemandDraftException;

public interface IDemandDraftService {

	int addDemandDraftDetails(DemandDraft demandDraft) throws DemandDraftException;
	DemandDraft getDemandDraftDetails(int transactionId) throws DemandDraftException ;
}
