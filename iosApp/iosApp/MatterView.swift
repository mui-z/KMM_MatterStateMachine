import SwiftUI
import shared

struct MatterView: View {
	@StateObject var matterFeature = ObservableMatterFeature()
	
	var body: some View {
		VStack {
			Text("Gas")
				.font(.largeTitle)
				.foregroundColor(!(matterFeature.state is MatterState.Gas) ? .gray : .black)
				.padding()

			Text("Liquid")
				.font(.largeTitle)
				.foregroundColor(!(matterFeature.state is MatterState.Liquid) ? .gray : .black)
				.padding()
			
			Text("Solid")
				.font(.largeTitle)
				.foregroundColor(!(matterFeature.state is MatterState.Solid) ? .gray : .black)
				.padding()

			HStack {
				Button {
					matterFeature.heat()
				} label: {
					Image(systemName: "flame.circle.fill")
						.resizable()
						.foregroundColor(matterFeature.state is MatterState.Gas ? .gray : .red)
						.frame(width: 50, height: 50)
				}
				.disabled(matterFeature.state is MatterState.Gas)
				.padding()
				
				Button {
					matterFeature.refrigerate()
				} label: {
					Image(systemName: "snowflake.circle.fill")
						.resizable()
						.foregroundColor(matterFeature.state is MatterState.Solid ? .gray : .blue)
						.frame(width: 50, height: 50)
				}
				.disabled(matterFeature.state is MatterState.Solid)
				.padding()
			}
			.padding(.vertical, 100)
		}
	}
}
