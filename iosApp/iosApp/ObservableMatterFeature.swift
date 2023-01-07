//
//  ObservableMatterFeature.swift
//  iosApp
//
//  Created by osushi on 2023/01/07.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

class ObservableMatterFeature: ObservableObject {
	@Published private(set) var state: MatterState
	@Published private(set) var stateText: String = ""
	
	private let feature: MatterFeature
	
	var stateWatcher: Closeable?
	
	init() {
		self.feature = MatterFeature(initialState: MatterState.Solid())
		
		self.state = feature.getCurrentState()
		
		stateWatcher = self.feature.watchState().watch { [weak self] state in
			self?.state = state
			
			switch state {
			case is MatterState.Solid:
				self?.stateText = "Solid"
			case is MatterState.Liquid:
				self?.stateText = "Liquid"
			case is MatterState.Gas:
				self?.stateText = "Gas"
			default:
				print("unknown state \(state)")
				self?.stateText = "unknown"
			}
		}
	}
	
	func heat() {
		feature.heat()
	}
	
	func refrigerate() {
		feature.refrigerate()
	}
	
	deinit {
		stateWatcher?.close()
	}
}
