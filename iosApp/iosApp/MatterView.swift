import SwiftUI
import shared

struct MatterView: View {
	@StateObject var matterFeature = ObservableMatterFeature()
	
	var body: some View {
		VStack {
			Text(matterFeature.stateText)
			
			HStack {
				Image(systemName: "flame.circle.fill")
					.resizable()
					.frame(width: 30, height: 30)
					.onTapGesture {
						matterFeature.heat()
					}
					.padding()
				
				Image(systemName: "snowflake.circle.fill")
					.resizable()
					.frame(width: 30, height: 30)
					.onTapGesture {
						matterFeature.refrigerate()
					}
					.padding()
			}
		}
	}
}
